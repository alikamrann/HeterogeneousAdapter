package com.example.heterogeneousadapter.viewholder

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.heterogeneousadapter.R
import com.example.heterogeneousadapter.model.Item
import com.example.heterogeneousadapter.model.ItemWithImage

class ImageViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.itemImageView)

    override fun bindSpecific(item: Item) {
        if (item is ItemWithImage) {
            Glide.with(itemView.context).load(item.imageUrl).into(imageView)
        }
    }
}