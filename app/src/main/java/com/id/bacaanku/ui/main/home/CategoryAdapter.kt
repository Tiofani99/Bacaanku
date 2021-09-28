package com.id.bacaanku.ui.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.LoadRequest
import com.id.bacaanku.data.remote.firebase.model.Category
import com.id.bacaanku.databinding.ItemCategoryBinding
import com.id.bacaanku.ui.category.NewsCategoryActivity

class CategoryAdapter(private val listCategory: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listCategory[position],listCategory,position)
    }

    override fun getItemCount(): Int = listCategory.size

    class ViewHolder(private val binding: ItemCategoryBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bindView(category: Category,list: ArrayList<Category>, position: Int) {
            with(binding){
                val imageLoaderSvg = ImageLoader.Builder(itemView.context)
                    .componentRegistry {
                        add(SvgDecoder(itemView.context))
                    }.build()

                val request = LoadRequest.Builder(itemView.context)
                    .data(category.imageUrl)
                    .target(binding.ivCategory)
                    .build()
                imageLoaderSvg.execute(request)

                tvCategoryName.text = category.name
                with(itemView){
                    setOnClickListener {
                        val intent = Intent(itemView.context, NewsCategoryActivity::class.java)
                        intent.putExtra(NewsCategoryActivity.EXTRA_POSITION,position)
                        intent.putExtra(NewsCategoryActivity.EXTRA_CATEGORY,list)
                        itemView.context.startActivity(intent)
                    }
                }
            }
        }
    }

}