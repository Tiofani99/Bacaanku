package com.id.bacaanku.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import coil.api.load
import com.google.android.material.appbar.AppBarLayout
import com.id.bacaanku.R
import com.id.bacaanku.databinding.ActivityNewsDetailBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.utils.COLLECTION
import com.id.bacaanku.utils.Helper.toTimeAgo
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlin.math.abs

class NewsDetailActivity : AppCompatActivity() {

    private var newsDetail: News? = null
    private lateinit var binding: ActivityNewsDetailBinding
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newsDetail = intent.getParcelableExtra(COLLECTION.EXTRA_NEWS)
        setNews(newsDetail!!)
    }


    private fun setNews(news: News){
        setCollapsing(news.title.toString())
        ivBackDrop.load(news.urlToImage)
        with(binding.contentDetail){
            tvTitle.text = news.title
            tvDesc.text = "${news.description}..."
            tvAuthor.text = news.author
            tvTime.text = news.publishedAt!!.toTimeAgo()
        }
    }

    private fun setCollapsing(title: String) {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.collapsingToolbar.title = ""
        binding.tvTitle.text = " "
        binding.collapsingToolbar.setCollapsedTitleTextColor(
            ContextCompat.getColor(
                this,
                R.color.white
            )
        )

        binding.appbar.setExpanded(true)
        val mAppBarLayout = findViewById<View>(R.id.appbar) as AppBarLayout
        mAppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1


            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout!!.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    binding.collapsingToolbar.title = title
                    binding.tvTitle.text = title
                    isShow = true
                } else if (isShow) {
                    binding.collapsingToolbar.title = " "
                    binding.tvTitle.text = " "
                    isShow = false
                }
            }

        })

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        this.menu = menu
        menuInflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }
}