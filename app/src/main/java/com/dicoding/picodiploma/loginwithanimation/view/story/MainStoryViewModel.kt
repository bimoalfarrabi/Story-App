package com.dicoding.picodiploma.loginwithanimation.view.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.loginwithanimation.data.StoryRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserModel
import java.io.File

class MainStoryViewModel(private val storyRepository: StoryRepository) : ViewModel() {

    fun uploadImage(file: File, description: String) = storyRepository.uploadImage(file, description)
}