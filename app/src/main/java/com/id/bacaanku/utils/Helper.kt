package com.id.bacaanku.utils

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
}