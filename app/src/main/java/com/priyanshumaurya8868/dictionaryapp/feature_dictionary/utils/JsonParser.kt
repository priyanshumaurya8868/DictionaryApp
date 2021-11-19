package com.priyanshumaurya8868.dictionaryapp.feature_dictionary.utils

import java.lang.reflect.Type

interface JsonParser  {
    fun <T> fromJson(json : String, type: Type): T?
    fun <T> toJson(obj: T, type: Type):String?
}