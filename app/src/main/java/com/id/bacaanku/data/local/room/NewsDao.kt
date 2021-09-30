package com.id.bacaanku.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.id.bacaanku.data.local.entity.NewsEntity

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(newsEntity: NewsEntity)

    @Delete
    fun delete(newsEntity: NewsEntity)

    @Query(value = "SELECT * FROM newsEntity")
    fun getBookmarked() : LiveData<List<NewsEntity>>

    @Query(value = "SELECT * FROM newsEntity WHERE title = :title")
    fun getDetail(title: String) : LiveData<NewsEntity>
}