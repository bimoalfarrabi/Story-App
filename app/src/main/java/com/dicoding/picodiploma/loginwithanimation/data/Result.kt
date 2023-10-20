package com.dicoding.picodiploma.loginwithanimation.data

sealed class Result<out R> private constructor() {
    data class Success<out T>(val result: T) : Result<T>()
    data class Error(val error: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
}
