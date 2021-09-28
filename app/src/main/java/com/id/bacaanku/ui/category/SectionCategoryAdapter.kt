package com.id.bacaanku.ui.category

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.id.bacaanku.data.remote.firebase.model.Category

class SectionCategoryAdapter(
    activity:AppCompatActivity,
    private  val listCategory:ArrayList<Category>,
) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int = listCategory.size

    override fun createFragment(position: Int): Fragment {
        return CategoryFragment.newInstance(listCategory, position)
    }
}