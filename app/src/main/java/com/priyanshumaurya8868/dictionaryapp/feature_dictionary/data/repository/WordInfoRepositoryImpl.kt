package com.priyanshumaurya8868.dictionaryapp.feature_dictionary.data.repository

import com.priyanshumaurya8868.dictionaryapp.core.util.Resource
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.data.local.WordInfoDao
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.data.remote.DictionaryApi
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.repo.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api : DictionaryApi,
    private val dao : WordInfoDao
) : WordInfoRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow{
        emit(Resource.Loading())

        val  wordInfos = dao.getWordInfos(word).map { it.toWorkInfo() }
        emit(Resource.Loading(wordInfos))

        try{
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfos(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWorkInfoEntity() })
        }catch(e: HttpException) { // in case  of invalid response
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = wordInfos
            ))
        } catch(e: IOException) { // internet ,parsing... etc
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = wordInfos
            ))
        }

        val newWordInfos = dao.getWordInfos(word).map { it.toWorkInfo() }
        emit(Resource.Success(newWordInfos))

    }
}