package com.student22110006.baitap04_22110006

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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
        var editText1 = findViewById<EditText>(R.id.editText1);
        var btnThem = findViewById<Button>(R.id.btnThem);
        var btnCapNhat = findViewById<Button>(R.id.btnCapNhat);

        var vitri = -1;

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
            vitri = position
            editText1.setText(text.toString())
        }
        //bắt sự kiện click giữ trên từng dòng của Listview
        lv.setOnItemLongClickListener { adapterView, view, position, id ->
            var text = adapterView.getItemAtPosition(position)
            // Hiển thị hộp thoại xác nhận xóa
            AlertDialog.Builder(this)
                .setTitle("Xóa môn học")
                .setMessage("Bạn có muốn xóa \"$text\" khỏi danh sách không?")
                .setPositiveButton("Có") { dialog, which ->
                    // Xóa phần tử khỏi danh sách
                    arrayList.removeAt(position)

                    // Cập nhật Adapter
                    Ad.notifyDataSetChanged()

                    Toast.makeText(this, "Đã xóa $text", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Không", null) // Đóng dialog nếu chọn "Không"
                .show()

            return@setOnItemLongClickListener true
        }
        btnThem.setOnClickListener {
            var text = editText1.text.toString()
            arrayList.add(text)
            Ad.notifyDataSetChanged()
            editText1.setText("")
        }
        btnCapNhat.setOnClickListener {
            var text = editText1.text.toString()
            arrayList.set(vitri, text)
            Ad.notifyDataSetChanged()
            editText1.setText("")
        }
    }
}