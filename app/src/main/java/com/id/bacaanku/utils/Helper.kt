package com.id.bacaanku.utils

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.github.marlonlom.utilities.timeago.TimeAgoMessages
import java.text.SimpleDateFormat
import java.util.*

object Helper {

    fun String.toTimeAgo(): String {
        val messages: TimeAgoMessages = TimeAgoMessages.Builder().withLocale(Locale("id")).build()
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(this)
        return TimeAgo.using(date.time, messages)
    }

    fun AppCompatActivity.toolbar(toolbar: Toolbar, titleStr: String = "") {
        setSupportActionBar(toolbar)
        supportActionBar?.title = titleStr
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.apply {
            setNavigationOnClickListener { finish() }
        }


    }

    fun View.hideView() {
        this.visibility = View.GONE
    }

    fun View.showView() {
        this.visibility = View.VISIBLE
    }
}