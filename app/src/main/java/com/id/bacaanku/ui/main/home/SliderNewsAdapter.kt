package com.id.bacaanku.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load
import com.id.bacaanku.R
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.databinding.ItemSlideLatestNewsBinding
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderNewsAdapter(private val listNews: ArrayList<ArticlesItem>) :
    SliderViewAdapter<SliderNewsAdapter.ViewHolder>() {


    class ViewHolder(view: View) : SliderViewAdapter.ViewHolder(view) {
        private val binding = ItemSlideLatestNewsBinding.bind(itemView)
        fun bindItem(articlesItem: ArticlesItem){
            binding.tvTitle.text = articlesItem.title
            binding.ivPhoto.load(articlesItem.urlToImage) {
                crossfade(true)
            }
        }
    }

    override fun getCount(): Int = listNews.size

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_slide_latest_news, parent, false)
        return SliderNewsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(listNews[position])
    }


}