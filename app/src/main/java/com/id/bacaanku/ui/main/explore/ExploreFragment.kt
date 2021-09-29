package com.id.bacaanku.ui.main.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.databinding.FragmentExploreBinding
import com.id.bacaanku.ui.category.adapter.SectionCategoryAdapter
import com.id.bacaanku.ui.main.NewsViewModel


class ExploreFragment : Fragment() {

    private var position: Int? = 0
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTabLayout()

    }


    private fun setTabLayout() {
        viewModel.getAllCategory()
        viewModel.listCategory.observe(viewLifecycleOwner, {
            val newAdapter = SectionCategoryAdapter(
                requireActivity() as AppCompatActivity,
                it as ArrayList<Category>
            )
            with(binding) {

                viewPager.adapter = newAdapter

                viewPager.currentItem = position!!
                TabLayoutMediator(tab, viewPager) { tab, position ->
                    tab.text = it[position].name
                }.attach()
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
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}