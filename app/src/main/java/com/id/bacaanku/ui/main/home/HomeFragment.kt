package com.id.bacaanku.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.bacaanku.R
import com.id.bacaanku.data.remote.response.ArticlesItem
import com.id.bacaanku.databinding.FragmentHomeBinding
import com.id.bacaanku.ui.main.NewsViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLatestNews()
    }
    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun showLatestNews(){
        viewModel.headLineNews.observe(viewLifecycleOwner,{
            binding.rvNews.apply {
                adapter = LatestNewsAdapter(it as ArrayList<ArticlesItem>)
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL, false)
            }
        })
    }


}