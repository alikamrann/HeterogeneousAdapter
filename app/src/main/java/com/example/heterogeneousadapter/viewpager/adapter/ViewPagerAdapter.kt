package com.example.heterogeneousadapter.viewpager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heterogeneousadapter.R


class ViewPagerAdapter(private val layouts: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    private var text: String = ""

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(text: String, layoutId: Int) {
            // پیدا کردن TextView در Layoutهای مختلف
            val textViewId = when (layoutId) {
                R.layout.layout1 -> R.id.textView1
                R.layout.layout2 -> R.id.textView2
                R.layout.layout3 -> R.id.textView3
                else -> throw IllegalArgumentException("Invalid layout ID")
            }
            val textView = itemView.findViewById<TextView>(textViewId)
            textView?.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(text, layouts[position])
    }

    override fun getItemCount(): Int = layouts.size

    override fun getItemViewType(position: Int): Int = layouts[position]

    // متد برای به‌روزرسانی متن
    fun updateText(newText: String) {
        this.text = newText
        notifyDataSetChanged() // به‌روزرسانی همه آیتم‌ها
    }
}