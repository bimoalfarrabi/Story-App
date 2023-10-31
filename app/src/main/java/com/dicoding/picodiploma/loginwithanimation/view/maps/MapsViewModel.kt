package com.dicoding.picodiploma.loginwithanimation.view.maps

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.picodiploma.loginwithanimation.data.StoryRepository
import com.dicoding.picodiploma.loginwithanimation.data.pref.UserModel

class MapsViewModel(private val storyRepository: StoryRepository) : ViewModel() {
    fun getStoriesWithLocation() = storyRepository.getStoriesWithLocation()
}