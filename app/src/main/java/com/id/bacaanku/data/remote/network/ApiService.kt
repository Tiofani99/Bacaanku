package com.id.bacaanku.data.remote.network


import com.id.bacaanku.BuildConfig
import com.id.bacaanku.data.remote.response.NewsHeadlineResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {
    @GET("top-headlines?country=id&apiKey=${"26504b3cb3f649ae97cb3ecab46d0f9e"}")
    fun getHeadlines(): Call<NewsHeadlineResponse>

    @GET("top-headlines?country=id&apiKey=${"26504b3cb3f649ae97cb3ecab46d0f9e"}")
    fun getHeadlinesByCategoryNew(
        @Query("category") query: String
    ): Call<NewsHeadlineResponse>

    @GET("everything")
    fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String? = "26504b3cb3f649ae97cb3ecab46d0f9e"
    ): Call<NewsHeadlineResponse>
}