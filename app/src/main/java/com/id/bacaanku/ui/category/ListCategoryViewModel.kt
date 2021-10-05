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

    private val _isLoading1 = MutableLiveData<Boolean>()
    val isLoading1: LiveData<Boolean> get() = _isLoading1
    private val _category1 = MutableLiveData<List<News>>()
    val category1: LiveData<List<News>> get() = _category1
    fun getCategory1() {
        _isLoading1.value = true
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("business")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading1.value = false
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category1.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoading1.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _isLoading2 = MutableLiveData<Boolean>()
    val isLoading2: LiveData<Boolean> get() = _isLoading2
    private val _category2 = MutableLiveData<List<News>>()
    val category2: LiveData<List<News>> get() = _category2
    fun getCategory2() {
        _isLoading2.value = true
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("entertainment")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading2.value = false
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category2.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoading2.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _isLoading3 = MutableLiveData<Boolean>()
    val isLoading3: LiveData<Boolean> get() = _isLoading3
    private val _category3 = MutableLiveData<List<News>>()
    val category3: LiveData<List<News>> get() = _category3
    fun getCategory3() {
        _isLoading3.value = true
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("health")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading3.value = false
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category3.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoading3.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _isLoading4 = MutableLiveData<Boolean>()
    val isLoading4: LiveData<Boolean> get() = _isLoading4
    private val _category4 = MutableLiveData<List<News>>()
    val category4: LiveData<List<News>> get() = _category4
    fun getCategory4() {
        _isLoading4.value = true
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("science")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading4.value = false
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category4.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoading4.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _isLoading5 = MutableLiveData<Boolean>()
    val isLoading5: LiveData<Boolean> get() = _isLoading5
    private val _category5 = MutableLiveData<List<News>>()
    val category5: LiveData<List<News>> get() = _category5
    fun getCategory5() {
        _isLoading5.value = true
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("sport")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading5.value = false
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category5.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoading5.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }

    private val _isLoading6 = MutableLiveData<Boolean>()
    val isLoading6: LiveData<Boolean> get() = _isLoading6
    private val _category6 = MutableLiveData<List<News>>()
    val category6: LiveData<List<News>> get() = _category6
    fun getCategory6() {
        _isLoading6.value = true
        val client = ApiConfig.getApiService().getHeadlinesByCategoryNew("technology")
        client.enqueue(object : Callback<NewsHeadlineResponse> {
            override fun onResponse(
                call: Call<NewsHeadlineResponse>,
                response: Response<NewsHeadlineResponse>
            ) {
                if (response.isSuccessful) {
                    _isLoading6.value = false
                    val listNews = DataMapper.mapResponsesToDomain(response.body()?.articles!!)
                    _category6.value = listNews
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<NewsHeadlineResponse>, t: Throwable) {
                _isLoading6.value = false
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