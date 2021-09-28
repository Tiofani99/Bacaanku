package com.id.bacaanku.ui.category.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.bacaanku.databinding.FragmentCategoryBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.category.ListCategoryViewModel
import com.id.bacaanku.ui.category.adapter.CategoryNewsAdapter

class HealthFragment : Fragment() {
    private val viewModel: ListCategoryViewModel by activityViewModels()
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCategory3()
        viewModel.category3.observe(viewLifecycleOwner, { list ->
            binding.rvNewsByCategory.apply {
                adapter = CategoryNewsAdapter(list as ArrayList<News>)
                layoutManager = LinearLayoutManager(context)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}