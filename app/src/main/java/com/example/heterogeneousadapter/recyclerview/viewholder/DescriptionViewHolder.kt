package com.example.heterogeneousadapter.recyclerview.viewholder

import android.view.View
import android.widget.TextView
import com.example.heterogeneousadapter.R
import com.example.heterogeneousadapter.recyclerview.model.Item
import com.example.heterogeneousadapter.recyclerview.model.ItemWithDescription

class DescriptionViewHolder(itemView: View) : BaseViewHolder(itemView) {
    private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

    override fun bindSpecific(item: Item) {
        if (item is ItemWithDescription) {
            descriptionTextView.text = item.description
        }
    }
}