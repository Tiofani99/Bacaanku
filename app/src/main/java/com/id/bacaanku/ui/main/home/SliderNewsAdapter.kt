package com.id.bacaanku.ui.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.id.bacaanku.R
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.databinding.ItemSlideLatestNewsBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.detail.NewsDetailActivity
import com.id.bacaanku.utils.COLLECTION
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderNewsAdapter(private val listNews: ArrayList<News>) :
    SliderViewAdapter<SliderNewsAdapter.ViewHolder>() {


    class ViewHolder(view: View) : SliderViewAdapter.ViewHolder(view) {
        private val binding = ItemSlideLatestNewsBinding.bind(itemView)
        fun bindItem(news: News) {
            binding.tvTitle.text = news.title
            binding.ivPhoto.load(news.urlToImage) {
                crossfade(true)
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

    override fun getCount(): Int {
        return 5
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_slide_latest_news, parent, false)
        return SliderNewsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(listNews[position])
    }


}