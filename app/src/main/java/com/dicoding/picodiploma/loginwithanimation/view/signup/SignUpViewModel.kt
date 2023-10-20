package com.dicoding.picodiploma.loginwithanimation.view.signup

import androidx.lifecycle.ViewModel
import com.dicoding.picodiploma.loginwithanimation.data.UserRepository
import com.dicoding.picodiploma.loginwithanimation.remote.response.RegisterResponse

class SignUpViewModel(private val userRepository: UserRepository) : ViewModel(){
    suspend fun register (name: String, email: String, password: String) : RegisterResponse {
        return userRepository.registerUser(name, email, password)
    }
}