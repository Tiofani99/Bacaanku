package com.id.bacaanku.ui.search

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.id.bacaanku.R
import com.id.bacaanku.databinding.ItemExploreNewsBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.detail.NewsDetailActivity
import com.id.bacaanku.utils.COLLECTION
import com.id.bacaanku.utils.Helper.toTimeAgo

class SearchAdapter(private val listNews: ArrayList<News>)
    : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding= ItemExploreNewsBinding.bind(itemView)
        fun bindItem(news: News) {
            with(binding){
                ivPhoto.load(news.urlToImage){
                    crossfade(true)
                }
                tvTitle.text = news.title
                tvTime.text = news.publishedAt?.toTimeAgo()
                tvDesc.text = news.description

            }

            with(itemView) {
                setOnClickListener {
                    val intent = Intent(context, NewsDetailActivity::class.java)
                    intent.putExtra(COLLECTION.EXTRA_NEWS, news)
                    context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_explore_news, parent, false)
        return SearchAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(listNews[position])
    }

    override fun getItemCount(): Int = listNews.size
}