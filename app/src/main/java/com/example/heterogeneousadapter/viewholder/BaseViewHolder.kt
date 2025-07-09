package com.example.heterogeneousadapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heterogeneousadapter.R
import com.example.heterogeneousadapter.model.Item

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)

    fun bindCommon(item: Item) {
        usernameTextView.text = item.username
    }

    abstract fun bindSpecific(item: Item)
}