package com.priyanshumaurya8868.dictionaryapp.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.model.WordInfo


@Entity
data class WordInfoEntity(
    val word: String,
    val phonetic: String,
    val origin: String,
    val meanings: List<Meaning>,
    @PrimaryKey val id: Int? = null
) {
    fun toWorkInfo() =
        WordInfo(
        meanings = meanings,
        word = word,
        origin = origin,
        phonetic = phonetic
    )
}