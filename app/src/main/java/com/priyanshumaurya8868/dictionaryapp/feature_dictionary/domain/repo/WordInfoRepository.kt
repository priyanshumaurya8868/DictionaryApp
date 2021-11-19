package com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.repo

import com.priyanshumaurya8868.dictionaryapp.core.util.Resource
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow


interface WordInfoRepository {

    fun getWordInfo(word:String) : Flow<Resource<List<WordInfo>>>
}