package com.id.bacaanku.ui.category.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.ui.category.list.*

class SectionCategoryAdapter(
    activity: AppCompatActivity,
    private val listCategory: ArrayList<Category>,
) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = listCategory.size

    override fun createFragment(position: Int): Fragment {
        val fragment: Fragment
        when (position) {
            0 -> {
                fragment = BusinessFragment()
                return fragment
            }
            1 -> {
                fragment = EntertainmentFragment()
                return fragment
            }
            2 -> {
                fragment = HealthFragment()
                return fragment
            }
            3 -> {
                fragment = ScienceFragment()
                return fragment
            }
            4 -> {
                fragment = SportFragment()
                return fragment
            }
            5 -> {
                fragment = TechFragment()
                return fragment
            }
            else -> {
                fragment = HealthFragment()
                return fragment
            }
        }
    }
}