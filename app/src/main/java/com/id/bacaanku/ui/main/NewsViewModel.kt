package com.id.bacaanku.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.id.bacaanku.BuildConfig
import com.id.bacaanku.data.remote.network.ApiConfig
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.data.remote.response.NewsHeadlineResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    private val _headlineNews = MutableLiveData<List<ArticlesItem>>()
    val headLineNews: LiveData<List<ArticlesItem>> get() = _headlineNews

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    companion object{
        private const val TAG = "NewsViewModel"
    }

    init{
        getHeadlineNews()
    }

    private fun getHeadlineNews(){
        _isLoading.value = true
        val client = ApiConfig.getApiService().getHeadlines()
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                _isLoading.value = false
                if(response.isSuccessful){
                    _headlineNews.value = response.body()?.articles!!
                }else{
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }
}