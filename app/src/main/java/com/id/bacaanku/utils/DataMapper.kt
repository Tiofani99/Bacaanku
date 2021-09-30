package com.id.bacaanku.utils


import com.id.bacaanku.data.local.entity.NewsEntity
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.model.News

object DataMapper {

    fun mapDomainToEntity(input: News): NewsEntity {
        return NewsEntity(
            publishedAt = input.publishedAt,
            author = input.author,
            urlToImage = input.urlToImage,
            description = input.description,
            title = input.title,
            url = input.url.toString(),
        )
    }

    fun mapResponsesToDomain(input: List<ArticlesItem>): List<News> {
        val listNews = ArrayList<News>()
        input.map {
            val news = News(
                publishedAt = it.publishedAt,
                author = it.author,
                urlToImage = it.urlToImage,
                description = it.description,
                title = it.title,
                url = it.url,
            )

            listNews.add(news)
        }

        return listNews
    }

    fun mapEntityToDomain(input: List<NewsEntity>): List<News> {
        val listNews = ArrayList<News>()
        input.map {
            val news = News(
                publishedAt = it.publishedAt,
                author = it.author,
                urlToImage = it.urlToImage,
                description = it.description,
                title = it.title,
                url = it.url,
            )

            listNews.add(news)
        }

        return listNews
    }


}