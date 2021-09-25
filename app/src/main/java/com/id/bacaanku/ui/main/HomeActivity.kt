package com.id.bacaanku.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.id.bacaanku.R
import com.id.bacaanku.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewModel.headLineNews.observe(this,{
//            Log.d("TESTH", "onCreate: ${it}")
//        })

        setUpNavigation()
        supportActionBar!!.hide()
        setupActionBarWithNavController(navController)
    }

    private fun setUpNavigation(){
        navController = findNavController(R.id.mainHostFragment)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav_menu,menu)
        binding.bottomBar.setupWithNavController(menu!!, navController)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }
}