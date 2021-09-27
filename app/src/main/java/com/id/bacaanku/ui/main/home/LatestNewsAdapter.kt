package com.id.bacaanku.ui.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.id.bacaanku.R
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.databinding.ItemLatestNewsBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.detail.NewsDetailActivity
import com.id.bacaanku.utils.COLLECTION
import com.id.bacaanku.utils.Helper.toTimeAgo
import java.util.*

class LatestNewsAdapter(private val listLatestNews: ArrayList<News>) :
    RecyclerView.Adapter<LatestNewsAdapter.ViewHolder>() {


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemLatestNewsBinding.bind(itemView)
        fun bindItem(news: News) {
            binding.tvAuthor.text = news.author.toString()
            binding.tvTitle.text = news.title
            binding.tvTimes.text = news.publishedAt!!.toTimeAgo()
            binding.ivPhoto.load(news.urlToImage) {
                crossfade(true)
            }
            with(itemView){
                setOnClickListener {
                    val intent = Intent(context, NewsDetailActivity::class.java)
                    intent.putExtra(COLLECTION.EXTRA_NEWS, news)
                    context.startActivity(intent)
                }
            }
        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LatestNewsAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_latest_news, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LatestNewsAdapter.ViewHolder, position: Int) {
        holder.bindItem(listLatestNews[position])
    }

    override fun getItemCount(): Int = listLatestNews.size
}