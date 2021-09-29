package com.id.bacaanku.ui.main.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.id.bacaanku.R
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.databinding.FragmentExploreBinding
import com.id.bacaanku.ui.category.adapter.SectionCategoryAdapter
import com.id.bacaanku.utils.Helper.hideView
import com.id.bacaanku.utils.Helper.showView


class ExploreFragment : Fragment() {

    private var listCategory: List<Category>? = null
    private var position: Int? = 0
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!


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
        setCollapsing()

    }


    private fun setCollapsing() {
        binding.collapsingToolbar.title = ""
        binding.persistentSearchView.hideView()
        binding.collapsingToolbar.setCollapsedTitleTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )

        binding.appbar.setExpanded(true)
        val mAppBarLayout = (requireActivity()).findViewById<View>(R.id.appbar) as AppBarLayout
        mAppBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1


            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout!!.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    binding.collapsingToolbar.title = " "
                    binding.persistentSearchView.showView()
                    isShow = true
                } else if (isShow) {
                    binding.collapsingToolbar.title = " "
                    binding.persistentSearchView.hideView()
                    isShow = false
                }
            }

        })

    }

    private fun setTabLayout() {
        val newAdapter = SectionCategoryAdapter(
            requireActivity() as AppCompatActivity,
            listCategory as ArrayList<Category>
        )
        with(binding.contentCategory) {

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

            (activity as AppCompatActivity).supportActionBar!!.elevation = 0f


        }
    }

}