package com.id.bacaanku.ui.category

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.id.bacaanku.data.remote.network.ApiConfig
import com.id.bacaanku.data.remote.response.NewsHeadlineResponse
import com.id.bacaanku.model.News
import com.id.bacaanku.utils.DataMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCategoryViewModel : ViewModel() {
    companion object {
        private const val TAG = "NewsViewModel"
    }

    private val _category1 = MutableLiveData<List<News>>()
    val category1: LiveData<List<News>> get() = _category1
    fun getCategory1() {
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("business")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category1.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _category2 = MutableLiveData<List<News>>()
    val category2: LiveData<List<News>> get() = _category2
    fun getCategory2() {
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("entertainment")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category2.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _category3 = MutableLiveData<List<News>>()
    val category3: LiveData<List<News>> get() = _category3
    fun getCategory3() {
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("health")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category3.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _category4 = MutableLiveData<List<News>>()
    val category4: LiveData<List<News>> get() = _category4
    fun getCategory4() {
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("science")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category4.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _category5 = MutableLiveData<List<News>>()
    val category5: LiveData<List<News>> get() = _category5
    fun getCategory5() {
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("sport")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category5.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _category6 = MutableLiveData<List<News>>()
    val category6: LiveData<List<News>> get() = _category6
    fun getCategory6() {
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("technology")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category6.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _headlineNews = MutableLiveData<List<News>>()
    val headLineNews: LiveData<List<News>> get() = _headlineNews
    fun getHeadlineNews() {
        val client = ApiConfig.getApiService().getHeadlines()
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _headlineNews.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }


}