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
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.category.ListCategoryViewModel
import com.id.bacaanku.utils.DataMapper
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {
    companion object {
        private const val TAG = "NewsViewModel"
    }


    private val _headlineNews = MutableLiveData<List<News>>()
    val headLineNews: LiveData<List<News>> get() = _headlineNews
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
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _headlineNews.value = listNews
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

    private val _isLoadingSearch = MutableLiveData<Boolean>()
    val isLoadingSearch: LiveData<Boolean> get() = _isLoadingSearch
    private val _search = MutableLiveData<List<News>>()
    val search: LiveData<List<News>> get() = _search
    fun searchNews(query :String) {
        _isLoadingSearch.value = true
        val client = ApiConfig.getApiService().getEverything(query)
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                _isLoadingSearch.value = false
                if (response.isSuccessful) {
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _search.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoadingSearch.value = false
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