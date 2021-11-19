package com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.usecases

import com.priyanshumaurya8868.dictionaryapp.core.util.Resource
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.model.WordInfo
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.repo.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    val repo: WordInfoRepository
) {

    operator fun invoke(word: String): Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return  flow{ }
        }
        return repo.getWordInfo(word )
    }

}