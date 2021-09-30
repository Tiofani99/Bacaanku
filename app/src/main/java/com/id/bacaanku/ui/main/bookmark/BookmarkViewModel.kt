package com.id.bacaanku.ui.main.bookmark

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.id.bacaanku.data.local.NewsRepository
import com.id.bacaanku.data.local.entity.NewsEntity

class BookmarkViewModel(application: Application): ViewModel() {
    private val newsRepository: NewsRepository = NewsRepository(application)

    fun getBookmark():LiveData<List<NewsEntity>> = newsRepository.getBookmarked()

    fun getBookmarkDetail(title: String):LiveData<NewsEntity> = newsRepository.getDetail(title)

    fun insert(newsEntity: NewsEntity) {
        newsRepository.insert(newsEntity)
    }

    fun delete(newsEntity: NewsEntity) {
        newsRepository.delete(newsEntity)
    }
}