package com.id.bacaanku.data.remote.network

import com.id.bacaanku.BuildConfig
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.data.remote.response.NewsCategory
import com.id.bacaanku.data.remote.response.NewsHeadlineResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("top-headlines?country=id&apiKey=${BuildConfig.API_KEY}")
    fun getHeadlines(): Call<NewsHeadlineResponse>

    @GET("top-headlines?country=id&apiKey=${BuildConfig.API_KEY}")
    fun getHeadlinesByCategoryNew(
        @Query("category") query: String
    ): Call<NewsHeadlineResponse>

    @GET("everything")
    fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String? = BuildConfig.API_KEY
    ): Call<NewsHeadlineResponse>
}