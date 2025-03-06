package com.student22110006.baitap04_22110006.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.student22110006.baitap04_22110006.R
import com.student22110006.baitap04_22110006.data.adapter.CustomAdapter
import com.student22110006.baitap04_22110006.data.model.User


class UserActivity : AppCompatActivity() {
    private lateinit var rvMultipleViewType: RecyclerView;
    private lateinit var mData: MutableList<Any>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvMultipleViewType = findViewById<RecyclerView>(R.id.rv_multipe_view_type)
        mData = ArrayList()

        mData.add(User("Nguyen Van Nghia", "Quan 11"))
        mData.add(R.drawable.siba)
        mData.add("Text 0")
        mData.add("Text 1")
        mData.add(User("Nguyen Hoang Minh", "Quan 3"))
        mData.add("Text 2")
        mData.add(R.drawable.siba)
        mData.add(R.drawable.siba)
        mData.add(User("Pham Nguyen Tam Phu", "Quan 10"))
        mData.add("Text 3")
        mData.add("Text 4")
        mData.add(User("Tran Van Phuc", "Quan 1"))
        mData.add(R.drawable.siba)

        val adapter = CustomAdapter(this, mData)
        rvMultipleViewType.setAdapter(adapter)
        rvMultipleViewType.setLayoutManager(LinearLayoutManager(this))
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}