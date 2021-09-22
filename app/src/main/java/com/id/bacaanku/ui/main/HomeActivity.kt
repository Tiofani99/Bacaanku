package com.id.bacaanku.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.id.bacaanku.R

class HomeActivity : AppCompatActivity() {
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel.headLineNews.observe(this,{
            Log.d("TESTH", "onCreate: ${it}")
        })

    }
}