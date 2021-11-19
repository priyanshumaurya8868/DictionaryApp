package com.priyanshumaurya8868.dictionaryapp.feature_dictionary.data.remote.dto

import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
){
    fun toWorkInfoEntity(): WordInfoEntity{
        return  WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}