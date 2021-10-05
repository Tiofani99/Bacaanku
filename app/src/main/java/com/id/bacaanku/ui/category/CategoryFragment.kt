package com.id.bacaanku.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.databinding.FragmentCategoryBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.category.adapter.CategoryNewsAdapter


private const val EXTRA_CATEGORY = "param1"
private const val EXTRA_POSITION = "param2"


class CategoryFragment : Fragment() {
    private var listCategory: List<Category>? = null
    private var position: Int? = 0
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ListCategoryViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listCategory = it.getParcelableArrayList(EXTRA_CATEGORY)
            position = it.getInt(EXTRA_POSITION, 0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryEndPoint = listCategory!![position!!].endPoint
        setData(categoryEndPoint!!)
    }

    private fun setData(categoryEndPoint: String? = null) {
        when (position) {
            0 -> {
                viewModel.isLoading1.observe(viewLifecycleOwner,{
                    showLoading(it)
                })
                viewModel.getCategory1()
                viewModel.category1.observe(viewLifecycleOwner, { list ->
                    binding.rvNewsByCategory.apply {
                        adapter = CategoryNewsAdapter(list as ArrayList<News>)
                        layoutManager = LinearLayoutManager(context)
                    }
                })
            }
            1 -> {
                viewModel.isLoading2.observe(viewLifecycleOwner,{
                    showLoading(it)
                })
                viewModel.getCategory2()
                viewModel.category2.observe(viewLifecycleOwner, { list ->
                    binding.rvNewsByCategory.apply {
                        adapter = CategoryNewsAdapter(list as ArrayList<News>)
                        layoutManager = LinearLayoutManager(context)
                    }
                })
            }
            2 -> {
                viewModel.isLoading3.observe(viewLifecycleOwner,{
                    showLoading(it)
                })
                viewModel.getCategory3()
                viewModel.category3.observe(viewLifecycleOwner, { list ->
                    binding.rvNewsByCategory.apply {
                        adapter = CategoryNewsAdapter(list as ArrayList<News>)
                        layoutManager = LinearLayoutManager(context)
                    }
                })
            }
            3 -> {
                viewModel.isLoading4.observe(viewLifecycleOwner,{
                    showLoading(it)
                })
                viewModel.getCategory4()
                viewModel.category4.observe(viewLifecycleOwner, { list ->
                    binding.rvNewsByCategory.apply {
                        adapter = CategoryNewsAdapter(list as ArrayList<News>)
                        layoutManager = LinearLayoutManager(context)
                    }
                })
            }
            4 -> {
                viewModel.isLoading5.observe(viewLifecycleOwner,{
                    showLoading(it)
                })
                viewModel.getCategory5()
                viewModel.category5.observe(viewLifecycleOwner, { list ->
                    binding.rvNewsByCategory.apply {
                        adapter = CategoryNewsAdapter(list as ArrayList<News>)
                        layoutManager = LinearLayoutManager(context)
                    }
                })
            }
            5 -> {
                viewModel.getCategory6()
                viewModel.isLoading6.observe(viewLifecycleOwner,{
                    showLoading(it)
                })
                viewModel.category6.observe(viewLifecycleOwner, { list ->
                    binding.rvNewsByCategory.apply {
                        adapter = CategoryNewsAdapter(list as ArrayList<News>)
                        layoutManager = LinearLayoutManager(context)
                    }
                })
            }
            else -> {
                viewModel.getHeadlineNews()
                viewModel.headLineNews.observe(viewLifecycleOwner, { list ->
                    binding.rvNewsByCategory.apply {
                        adapter = CategoryNewsAdapter(list as ArrayList<News>)
                        layoutManager = LinearLayoutManager(context)
                    }
                })
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.rvNewsByCategory.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.rvNewsByCategory.visibility = View.VISIBLE
            binding.progressBar.visibility = View.GONE
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(listCategory: ArrayList<Category>? = null, position: Int) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(EXTRA_CATEGORY, listCategory)
                    putInt(EXTRA_POSITION, position)
                }
            }
    }
}