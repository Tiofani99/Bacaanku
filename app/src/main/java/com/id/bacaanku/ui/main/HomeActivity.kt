package com.id.bacaanku.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.id.bacaanku.R
import com.id.bacaanku.databinding.ActivityHomeBinding
import com.id.bacaanku.ui.main.bookmark.BookmarkFragment
import com.id.bacaanku.ui.main.explore.ExploreFragment
import com.id.bacaanku.ui.main.home.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var exitTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mFragmentManager = supportFragmentManager

        val homeFragment: Fragment = HomeFragment()
        val exploreFragment: Fragment = ExploreFragment()
        val bookmarkFragment: Fragment = BookmarkFragment()
        var active = homeFragment
        mFragmentManager.beginTransaction().add(R.id.mainHostFragment, bookmarkFragment, "3")
            .hide(bookmarkFragment).commit()
        mFragmentManager.beginTransaction().add(R.id.mainHostFragment, exploreFragment, "2")
            .hide(exploreFragment).commit()
        mFragmentManager.beginTransaction().add(R.id.mainHostFragment, homeFragment, "1").commit()

        bottomBar.onItemSelected = {
            when (it) {
                0 -> {
                    mFragmentManager.beginTransaction().hide(active).show(homeFragment).commit()
                    active = homeFragment
                }

                1 -> {
                    mFragmentManager.beginTransaction().hide(active).show(exploreFragment).commit()
                    active = exploreFragment
                }

                2 -> {
                    mFragmentManager.beginTransaction().hide(active).show(bookmarkFragment).commit()
                    active = bookmarkFragment
                }
            }

        }
    }

    override fun onBackPressed() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            finish()
        }

    }
}