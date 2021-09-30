package com.id.bacaanku.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import coil.api.load
import com.google.android.material.appbar.AppBarLayout
import com.id.bacaanku.R
import com.id.bacaanku.databinding.ActivityNewsDetailBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.main.ViewModelFactory
import com.id.bacaanku.ui.main.bookmark.BookmarkViewModel
import com.id.bacaanku.utils.COLLECTION
import com.id.bacaanku.utils.DataMapper.mapDomainToEntity
import com.id.bacaanku.utils.Helper.toTimeAgo
import kotlinx.android.synthetic.main.activity_news_detail.*


class NewsDetailActivity : AppCompatActivity() {

    private var newsDetail: News? = null
    private lateinit var binding: ActivityNewsDetailBinding
    private var menu: Menu? = null
    private lateinit var viewModel: BookmarkViewModel

    // true sudah ada false belum ada
    private var bookmarkState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        newsDetail = intent.getParcelableExtra(COLLECTION.EXTRA_NEWS)
        setNews(newsDetail!!)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        this.menu = menu
        menuInflater.inflate(R.menu.menu_item, menu)
        setBookmarkButton(bookmarkState)
        return super.onCreateOptionsMenu(menu)
    }


    private fun setNews(news: News) {
        viewModel = obtainViewModel(this)
        setCollapsing(news.title.toString())
        ivBackDrop.load(news.urlToImage)
        with(binding.contentDetail) {
            tvTitle.text = news.title
            tvDesc.text = "${news.description}..."
            tvAuthor.text = news.author
            tvTime.text = news.publishedAt!!.toTimeAgo()
            btnReadMore.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(news.url)))
            }
        }
        setBookmarkState(news.title)
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


    private fun setBookmarkState(title: String?) {
        viewModel.getBookmarkDetail(title.toString()).observe(this, {
            bookmarkState = it != null
            Log.d("TBTB", "setBookmarkState: $bookmarkState")
        })
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            actionBookmark()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actionBookmark() {
        if (bookmarkState) {
            val bookmark = mapDomainToEntity(newsDetail!!)
            viewModel.delete(bookmark)
            bookmarkState = false
            Toast.makeText(this, "Berhasil dihapus", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            val bookmark = mapDomainToEntity(newsDetail!!)
            Toast.makeText(this, "Berhasil disimpan", Toast.LENGTH_SHORT).show()
            bookmarkState = true
            viewModel.insert(bookmark)
        }
        setBookmarkButton(bookmarkState)
    }

    private fun setBookmarkButton(state: Boolean) {
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bookmark)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_no_bookmark)
        }
    }

    private fun obtainViewModel(activity: AppCompatActivity): BookmarkViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(BookmarkViewModel::class.java)
    }
}