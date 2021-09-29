package com.id.bacaanku.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.core.view.isEmpty
import androidx.core.view.isNotEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.bacaanku.R
import com.id.bacaanku.databinding.ActivityNewsSearchBinding
import com.id.bacaanku.model.News
import com.id.bacaanku.ui.main.NewsViewModel
import com.paulrybitskyi.persistentsearchview.PersistentSearchView
import com.paulrybitskyi.persistentsearchview.listeners.OnSearchConfirmedListener
import com.paulrybitskyi.persistentsearchview.listeners.OnSearchQueryChangeListener

class NewsSearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsSearchBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSearch()
    }


    private fun setSearch(){
        with(binding.persistentSearchView){
            setDismissOnTouchOutside(true)
            setDimBackground(true)
            isClearInputButtonEnabled = true
            setQueryInputGravity(Gravity.START or Gravity.CENTER)
            setOnLeftBtnClickListener {
                onBackPressed()
            }
            setOnClearInputBtnClickListener {
                // Handle the clear input button click
            }
            OnSearchConfirmedListener { searview, query ->
                searchData(query)
                searview.collapse()
            }
            setSuggestionsDisabled(true)

        }

    }

    private fun searchData(query: String){
        viewModel.searchNews(query)
        viewModel.search.observe(this,{
            with(binding.rvSearch){
                adapter = SearchAdapter(it as ArrayList<News>)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
        })
    }
}