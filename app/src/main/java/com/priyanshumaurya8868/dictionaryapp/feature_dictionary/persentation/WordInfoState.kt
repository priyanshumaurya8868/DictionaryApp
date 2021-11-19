package com.priyanshumaurya8868.dictionaryapp.feature_dictionary.persentation

import com.priyanshumaurya8868.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoState(
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)
