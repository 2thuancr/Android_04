package com.student22110006.baitap04_22110006.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.student22110006.baitap04_22110006.R
import com.student22110006.baitap04_22110006.data.adapter.CustomAnimationAdapter


class MainAnimationActivity : AppCompatActivity() {
    private lateinit var btnAddItem: Button;
    private lateinit var rvItems: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_animation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnAddItem = findViewById<View>(R.id.btn_add_item) as Button
        rvItems = findViewById<View>(R.id.rv_items) as RecyclerView

        val data: MutableList<String> = ArrayList()
        for (i in 0..4) {
            data.add("item $i")
        }

        val adapter = CustomAnimationAdapter(data)
        rvItems.adapter = adapter
        rvItems.layoutManager = LinearLayoutManager(this)

        // set ItemAnimator for RecyclerView
        rvItems.itemAnimator = DefaultItemAnimator()

        btnAddItem.setOnClickListener {
            adapter.addItem("new item")
            rvItems.scrollToPosition(adapter.itemCount - 1)
        }
    }
}