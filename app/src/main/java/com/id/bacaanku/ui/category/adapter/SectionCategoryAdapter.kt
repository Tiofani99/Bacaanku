package com.id.bacaanku.ui.category.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.ui.category.CategoryFragment

class SectionCategoryAdapter(
    activity: AppCompatActivity,
    private val listCategory: ArrayList<Category>,
) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = listCategory.size

    override fun createFragment(position: Int): Fragment {
        return CategoryFragment.newInstance(listCategory, position)
    }
}