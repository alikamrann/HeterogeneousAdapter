package com.example.heterogeneousadapter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heterogeneousadapter.recyclerview.adapter.HeterogeneousAdapter
import com.example.heterogeneousadapter.recyclerview.model.ItemWithDescription
import com.example.heterogeneousadapter.recyclerview.model.ItemWithImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // نمونه داده
        val items = listOf(
            ItemWithImage("کاربر ۱", "https://picsum.photos/200/300"),
            ItemWithDescription("کاربر ۲", "توضیحات برای کاربر ۲"),
            ItemWithImage("کاربر ۳", "https://picsum.photos/200/300"),
            ItemWithImage("کاربر ۱", "https://picsum.photos/200/300"),
            ItemWithDescription("کاربر ۲", "توضیحات برای کاربر ۲"),
            ItemWithDescription("کاربر ۲", "توضیحات برای کاربر ۲"),
            ItemWithDescription("کاربر ۲", "توضیحات برای کاربر ۲"),
            ItemWithImage("کاربر ۳", "https://picsum.photos/200/300"),
            ItemWithImage("کاربر ۳", "https://picsum.photos/200/300"),
            ItemWithImage("کاربر ۳", "https://picsum.photos/200/300"),
            ItemWithImage("کاربر ۳", "https://picsum.photos/200/300"),
            // ... سایر آیتم‌ها
        )

        val adapter = HeterogeneousAdapter(items)
        recyclerView.adapter = adapter
    }
}
