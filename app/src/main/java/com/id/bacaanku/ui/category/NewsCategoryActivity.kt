package com.id.bacaanku.ui.category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.databinding.ActivityNewsCategoryBinding
import com.id.bacaanku.utils.Helper.toolbar

class NewsCategoryActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_CATEGORY = "extra category"
        const val EXTRA_POSITION = "extra position"
    }

    private lateinit var binding: ActivityNewsCategoryBinding
    private var listCategory: List<Category>? = null
    private var position: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listCategory = intent.getParcelableArrayListExtra(EXTRA_CATEGORY)
        position = intent.getIntExtra(EXTRA_POSITION, 0)
        setTabLayout()
    }

    private fun setTabLayout() {
        with(binding) {
            toolbar(toolbar)
            val newAdapter = SectionCategoryAdapter(
                this@NewsCategoryActivity,
                listCategory as ArrayList<Category>
            )

            viewPager.adapter = newAdapter
            TabLayoutMediator(tab, viewPager) { tab, position ->
                tab.text = (listCategory as ArrayList<Category>)[position].name
            }.attach()

            viewPager.currentItem = position!!
            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                    if (position > 0 && positionOffset == 0.0f && positionOffsetPixels == 0) {
                        viewPager.layoutParams.height =
                            viewPager.getChildAt(0).height
                    }
                }
            })

            supportActionBar!!.elevation = 0f


        }
    }


}