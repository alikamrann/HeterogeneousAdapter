package com.example.heterogeneousadapter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.heterogeneousadapter.recyclerview.adapter.HeterogeneousAdapter
import com.example.heterogeneousadapter.recyclerview.model.ItemWithDescription
import com.example.heterogeneousadapter.recyclerview.model.ItemWithImage
import com.example.heterogeneousadapter.viewpager.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupRv()

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val editText = findViewById<android.widget.EditText>(R.id.editText)
        val layouts = listOf(R.layout.layout1, R.layout.layout2, R.layout.layout3)
        adapter = ViewPagerAdapter(layouts)
        viewPager.adapter = adapter
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // گوش دادن به تغییرات EditText
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                adapter.updateText(s.toString())
            }
        })
    }
    private fun setupRv(){
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
