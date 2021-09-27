package com.id.bacaanku.ui.main.home

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.github.marlonlom.utilities.timeago.TimeAgoMessages
import com.id.bacaanku.R
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.databinding.ItemLatestNewsBinding
import com.id.bacaanku.utils.Helper.toTimeAgo
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class LatestNewsAdapter(private val listLatestNews: ArrayList<ArticlesItem>): RecyclerView.Adapter<LatestNewsAdapter.ViewHolder>() {


    class ViewHolder (private val view :View) : RecyclerView.ViewHolder(view){
        private val binding = ItemLatestNewsBinding.bind(itemView)
        fun bindItem(articlesItem: ArticlesItem){
            binding.tvAuthor.text = articlesItem.author.toString()
            binding.tvTitle.text = articlesItem.title
            binding.tvTimes.text = articlesItem.publishedAt!!.toTimeAgo()
            binding.ivPhoto.load(articlesItem.urlToImage){
                crossfade(true)
            }
            with(itemView){
                setOnClickListener {
                }
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestNewsAdapter.ViewHolder {
        val view =
        LayoutInflater.from(parent.context).inflate(R.layout.item_latest_news, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LatestNewsAdapter.ViewHolder, position: Int) {
        holder.bindItem(listLatestNews[position])
    }

    override fun getItemCount(): Int = listLatestNews.size
    }