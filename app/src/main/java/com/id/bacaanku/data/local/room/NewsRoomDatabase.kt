package com.id.bacaanku.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.id.bacaanku.data.local.entity.NewsEntity

@Database(entities = [NewsEntity::class], version = 1)
abstract class NewsRoomDatabase : RoomDatabase() {
    abstract fun newsDao():NewsDao

    companion object{
        @Volatile
        private var INSTANCE: NewsRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context):NewsRoomDatabase{
            if(INSTANCE == null){
                synchronized(NewsRoomDatabase::class){}
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        NewsRoomDatabase::class.java, "news_database")
                        .build()
                }
            }

            return INSTANCE as NewsRoomDatabase
        }
    }
}