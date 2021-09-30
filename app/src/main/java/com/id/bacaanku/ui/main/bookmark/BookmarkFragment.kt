package com.id.bacaanku.ui.main.bookmark

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.bacaanku.databinding.FragmentBookmarkBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.category.adapter.CategoryNewsAdapter
import com.id.bacaanku.ui.main.ViewModelFactory
import com.id.bacaanku.ui.main.home.CategoryAdapter
import com.id.bacaanku.utils.DataMapper


class BookmarkFragment : Fragment() {

    private var position: Int? = 0
    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BookmarkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookmarkBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = obtainViewModel(requireActivity() as AppCompatActivity)
        viewModel.getBookmark().observe(viewLifecycleOwner,{
            with(binding.rvNewsByCategory){
                layoutManager = LinearLayoutManager(context)
                adapter = CategoryNewsAdapter(DataMapper.mapEntityToDomain(it) as ArrayList<News>)
            }
        })

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun obtainViewModel(activity: AppCompatActivity): BookmarkViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(BookmarkViewModel::class.java)
    }
}