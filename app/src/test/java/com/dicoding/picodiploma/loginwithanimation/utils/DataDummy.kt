package com.dicoding.picodiploma.loginwithanimation.utils

import com.dicoding.picodiploma.loginwithanimation.remote.response.HomeResponse
import com.dicoding.picodiploma.loginwithanimation.remote.response.ListStoryItem
import com.dicoding.picodiploma.loginwithanimation.remote.response.LoginResponse
import com.dicoding.picodiploma.loginwithanimation.remote.response.LoginResult
import com.dicoding.picodiploma.loginwithanimation.remote.response.RegisterResponse
import com.dicoding.picodiploma.loginwithanimation.remote.response.UploadResponse

object DataDummy {

    fun generateDummyStoryResponse(): HomeResponse {
        val listStories = ArrayList<ListStoryItem>()
        for (i in 1..20) {
            val story = ListStoryItem(
                photoUrl = "https://img.freepik.com/free-photo/cyberpunk-urban-scenery_23-2150712488.jpg",
                createdAt = "2012-12-12T12:12:12Z",
                name = "name $i",
                description = "description $i",
                lon = i.toDouble() * 10,
                id = "id $i",
                lat = i.toDouble() * 10
            )
            listStories.add(story)
        }
        return HomeResponse(
            error = false,
            message = "Story fetched successfully",
            listStory = listStories
        )
    }

    fun generateDummyCreateStory(): UploadResponse {
        return UploadResponse(
            error = false,
            message = "upload success"
        )
    }

    fun generateDummyRegister(): RegisterResponse {
        return RegisterResponse(
            error = false,
            message = "register success"
        )
    }

    fun generateDummyLogin(): LoginResponse {
        return LoginResponse(
            error = false,
            message = "login success",
            loginResult = LoginResult(
                name = "Arif Farizin",
                userId = "user-yj5pc_LARC_AgK61",
                token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1c2VyLXlqNXBjX0xBUkNfQWdLNjEiLCJpYXQiOjE2NDE3OTk5NDl9.flEMaQ7zsdYkxuyGbiXjEDXO8kuDTcI__3UjCwt6R_I"
            )
        )
    }
}