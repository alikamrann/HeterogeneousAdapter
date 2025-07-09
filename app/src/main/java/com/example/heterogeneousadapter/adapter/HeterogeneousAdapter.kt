package com.example.heterogeneousadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.heterogeneousadapter.R
import com.example.heterogeneousadapter.model.Item
import com.example.heterogeneousadapter.model.VIEW_TYPE_IMAGE
import com.example.heterogeneousadapter.model.VIEW_TYPE_TEXT
import com.example.heterogeneousadapter.viewholder.BaseViewHolder
import com.example.heterogeneousadapter.viewholder.DescriptionViewHolder
import com.example.heterogeneousadapter.viewholder.ImageViewHolder

class HeterogeneousAdapter(private val items: List<Item>) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return items[position].viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            VIEW_TYPE_IMAGE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_with_image, parent, false)
                ImageViewHolder(view)
            }
            VIEW_TYPE_TEXT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_with_description, parent, false)
                DescriptionViewHolder(view)
            }
            // ... سایر ViewHolderها
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = items[position]
        holder.bindCommon(item) // تنظیم یوزرنیم
        holder.bindSpecific(item) // تنظیم ویژگی‌های خاص
    }

    override fun getItemCount(): Int = items.size
}