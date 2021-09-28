package com.id.bacaanku.ui.category.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.id.bacaanku.databinding.ItemExploreNewsBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.detail.NewsDetailActivity
import com.id.bacaanku.utils.COLLECTION
import com.id.bacaanku.utils.Helper.toTimeAgo

class CategoryNewsAdapter(private val listNews: ArrayList<News>) :
    RecyclerView.Adapter<CategoryNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExploreNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listNews.size


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindItem(listNews[position])
    }

    class ViewHolder(val binding: ItemExploreNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
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


}