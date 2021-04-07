package com.example.genderfinder.repository

import com.example.genderfinder.api.RetrofitInstance
import com.example.genderfinder.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post>
    {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(name: String): Response<Post>
    {
        return RetrofitInstance.api.getPosts2(name)
    }
}