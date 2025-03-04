package com.student22110006.baitap04_22110006

import android.os.Bundle
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
import com.student22110006.baitap04_22110006.data.MonHoc
import com.student22110006.baitap04_22110006.data.MonHocAdapter


class ListViewActivity : AppCompatActivity() {

    //khai báo
    private lateinit var listView: ListView;
    private lateinit var editText1: EditText;
    private lateinit var btnThem: Button;
    private lateinit var btnCapNhat: Button;
    private lateinit var arrayList: ArrayList<MonHoc>;
    private lateinit var adapter: MonHocAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listview)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var vitri = -1;

        // ánh xạ
        this.AnhXa();

        // Tạo Adapter
        adapter = MonHocAdapter(
            this,   // Context: màn hình hiển thị
            R.layout.row_monhoc, //Dạng Layout muốn đổ vào
            this.arrayList       //Dữ lệu List đỗ vào
        );

        // Truyền dữ liệu từ adapter ra listview
        this.listView.adapter = this.adapter;

        //bắt sự kiện click nhanh trên từng dòng của Listview
        listView.setOnItemClickListener { adapterView, view, position, id ->
             var text = adapterView.getItemAtPosition(position)
            //var text = arrayList.get(position)
            // Hiển thị vị trí item được click
            Toast.makeText(this, "$position - $text", Toast.LENGTH_SHORT).show()
            vitri = position
            editText1.setText(text.toString())
        }

        //bắt sự kiện click giữ trên từng dòng của Listview
        listView.setOnItemLongClickListener { adapterView, view, position, id ->
            var text = adapterView.getItemAtPosition(position)
            // Hiển thị hộp thoại xác nhận xóa
            AlertDialog.Builder(this)
                .setTitle("Xóa môn học")
                .setMessage("Bạn có muốn xóa \"$text\" khỏi danh sách không?")
                .setPositiveButton("Có") { dialog, which ->
                    // Xóa phần tử khỏi danh sách
                    arrayList.removeAt(position)

                    // Cập nhật Adapter
                    adapter.notifyDataSetChanged()

                    Toast.makeText(this, "Đã xóa $text", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Không", null) // Đóng dialog nếu chọn "Không"
                .show()

            return@setOnItemLongClickListener true
        }

        btnThem.setOnClickListener {
            var text = editText1.text.toString()
            arrayList.add(MonHoc(text,"Môn học $text", R.drawable.siba));
            this.adapter.notifyDataSetChanged()
            this.editText1.setText("")
        }

        btnCapNhat.setOnClickListener {
            val text = editText1.text.toString()
            if (vitri >= 0 && vitri < arrayList.size) {
                arrayList[vitri] = MonHoc(text, "Môn học $text", R.drawable.siba)
                adapter.notifyDataSetChanged()
                editText1.setText("")
                Toast.makeText(this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Chọn một môn học để cập nhật!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun AnhXa() {
        this.listView = findViewById<ListView>(R.id.listview);
        this.editText1 = findViewById<EditText>(R.id.editText1);
        this.btnThem = findViewById<Button>(R.id.btnThem);
        this.btnCapNhat = findViewById<Button>(R.id.btnCapNhat);

        //Thêm dữ liệu vào List
        arrayList = ArrayList()
        arrayList.add(MonHoc("Java","Java 1",R.drawable.java));
        arrayList.add(MonHoc("C#","C# 1",R.drawable.c));
        arrayList.add(MonHoc("PHP","PHP 1",R.drawable.php));
        arrayList.add(MonHoc("Kotlin","Kotlin  1",R.drawable.kotlin));
        arrayList.add(MonHoc("Dart","Dart 1",R.drawable.dart));
    }

}