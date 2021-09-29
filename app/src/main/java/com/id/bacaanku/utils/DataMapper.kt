package com.id.bacaanku.utils


import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.model.News

object DataMapper {

    fun mapArticleItemToDomain(input: ArticlesItem): News {
        return News(
            publishedAt = input.publishedAt,
            author = input.author,
            urlToImage = input.urlToImage,
            description = input.description,
            source = input.source,
            title = input.title,
            url = input.url,
        )
    }

    fun mapResponsesToDomain(input: List<ArticlesItem>): List<News> {
        val listNews = ArrayList<News>()
        input.map {
            val news = News(
                publishedAt = it.publishedAt,
                author = it.author,
                source = it.source,
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