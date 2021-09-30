package com.id.bacaanku.data.local

import android.app.Application
import androidx.lifecycle.LiveData
import com.id.bacaanku.data.local.entity.NewsEntity
import com.id.bacaanku.data.local.room.NewsDao
import com.id.bacaanku.data.local.room.NewsRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class NewsRepository(application: Application) {
    private val mNewsDao: NewsDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NewsRoomDatabase.getDatabase(application)
        mNewsDao = db.newsDao()
    }

    fun getBookmarked():LiveData<List<NewsEntity>> = mNewsDao.getBookmarked()

    fun getDetail(title: String):LiveData<NewsEntity> = mNewsDao.getDetail(title)

    fun insert(newsEntity: NewsEntity){
        executorService.execute{mNewsDao.insert(newsEntity)}
    }

    fun delete(newsEntity: NewsEntity){
        executorService.execute{mNewsDao.delete(newsEntity)}
    }

}