package com.id.bacaanku.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.id.bacaanku.data.remote.firebase.CategoryService
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.data.remote.network.ApiConfig
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.data.remote.response.NewsHeadlineResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    companion object {
        private const val TAG = "NewsViewModel"
    }


    private val _headlineNews = MutableLiveData<List<ArticlesItem>>()
    val headLineNews: LiveData<List<ArticlesItem>> get() = _headlineNews
    fun getHeadlineNews() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getHeadlines()
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _headlineNews.value = response.body()?.articles!!
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading


    private val _listCategory = MutableLiveData<List<Category>>()
    val listCategory: LiveData<List<Category>> = _listCategory
    fun getAllCategory() = viewModelScope.launch {
        CategoryService.getAllCategory {
            _listCategory.value = it
        }
    }

}