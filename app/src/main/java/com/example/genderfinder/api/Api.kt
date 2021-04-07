package com.example.genderfinder.api

import com.example.genderfinder.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {
    @GET("helloworld/alperen")
    suspend fun getPost(): Response<Post>

    @GET("helloworld/{postName}")
    suspend fun getPosts2(
        @Path("postName") name: String
    ): Response<Post>
}