package com.id.bacaanku.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.id.bacaanku.R
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.databinding.FragmentCategoryBinding
import com.id.bacaanku.ui.main.NewsViewModel
import java.text.FieldPosition


private const val EXTRA_CATEGORY = "param1"
private const val EXTRA_POSITION = "param2"


class CategoryFragment : Fragment() {
    private var listCategory: List<Category>? = null
    private var position: Int? = 0
    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NewsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            listCategory = it.getParcelableArrayList(EXTRA_CATEGORY)
            position = it.getInt(EXTRA_POSITION,0)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryEndPoint = listCategory!![position!!].endPoint
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