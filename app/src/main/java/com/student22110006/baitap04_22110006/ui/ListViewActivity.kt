package com.student22110006.baitap04_22110006

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listview)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // ánh xạ
        //var listView = findViewById<ListView>(R.id.listview)
        var lv = findViewById<ListView>(R.id.listview);
        var arrayList = ArrayList<String>();
        arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kotlin");
        arrayList.add("Dart");

        // Tạo Adapter
        var Ad : ArrayAdapter<String> = ArrayAdapter(
            this,   // Context: màn hình hiển thị
            android.R.layout.simple_list_item_1, //Dạng Layout muốn đổ vào
            arrayList       //Dữ lệu List đỗ vào
        );
        // Gắn Adapter vào ListView
        lv.adapter = Ad;

        //bắt sự kiện click nhanh trên từng dòng của Listview
        lv.setOnItemClickListener { adapterView, view, position, id ->
             var text = adapterView.getItemAtPosition(position)
            //var text = arrayList.get(position)
            // Hiển thị vị trí item được click
            Toast.makeText(this, "$position - $text", Toast.LENGTH_SHORT).show()
        }
        //bắt sự kiện click giữ trên từng dòng của Listview
        lv.setOnItemLongClickListener { adapterView, view, position, id ->
            var text = adapterView.getItemAtPosition(position)
            Toast.makeText(this, "Bạn đang nhấn giữ $position - $text", Toast.LENGTH_SHORT).show()
            return@setOnItemLongClickListener true
        }

    }
}