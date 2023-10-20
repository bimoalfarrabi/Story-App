package com.dicoding.picodiploma.loginwithanimation.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserModel
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserPreference
import com.dicoding.picodiploma.loginwithanimation.remote.response.LoginResponse
import com.dicoding.picodiploma.loginwithanimation.remote.response.RegisterResponse
import com.dicoding.picodiploma.loginwithanimation.remote.retrofit.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserRepository private constructor(
    private val apiService: ApiService,
    private val userPreference: UserPreference
) : CoroutineScope {

    fun saveSession(user: UserModel) {
        launch(Dispatchers.IO) {
            userPreference.saveSession(user)
        }
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    suspend fun registerUser(name: String, email: String, password: String) : RegisterResponse {
        return apiService.register(name, email, password)
    }

    fun loginUser(email: String, password: String) : LiveData<Result<LoginResponse>> = liveData {
        emit(Result.Loading)
        val result = apiService.login(email, password)
        if (result.error == false) {
            emit(Result.Success(result))
        } else {
            emit(Result.Error(result.message.toString()))
        }
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: UserPreference
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(apiService, userPreference)
            }.also { instance = it }
    }

    override val coroutineContext: CoroutineContext get() = Dispatchers.Main
}