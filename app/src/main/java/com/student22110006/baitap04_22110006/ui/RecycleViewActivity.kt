package com.student22110006.baitap04_22110006.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.student22110006.baitap04_22110006.R
import com.student22110006.baitap04_22110006.data.adapter.SongAdapter
import com.student22110006.baitap04_22110006.data.model.Song


class RecycleViewActivity : AppCompatActivity() {
    private lateinit var rvSongs: RecyclerView;
    private lateinit var mSongAdapter: SongAdapter;
    private lateinit var mSongs: MutableList<Song>;
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rv_songs)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ánh xạ
        this.AnhXa();

        // Tạo adapter
        mSongAdapter = SongAdapter(this, mSongs)
        rvSongs.adapter = mSongAdapter

        // Tạo Layout Manager

        // val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // rvSongs.layoutManager = linearLayoutManager
        val gridLayoutManager = GridLayoutManager(this, 2)
        rvSongs.layoutManager = gridLayoutManager

        // Thêm animation
        rvSongs.itemAnimator = DefaultItemAnimator()
    }

    private fun AnhXa() {
        rvSongs = findViewById<View>(R.id.rv_songs) as RecyclerView

        // Create song data
        mSongs = ArrayList<Song>()
        mSongs.add(
            Song(
                "60696",
                "NẾU EM CÒN TỒN TẠI",
                "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay",
                "Trịnh Đình Quang"
            )
        )
        mSongs.add(
            Song(
                "60697",
                "NGỐC",
                "Có rất nhiều những câu chuyện Em đã dấu riêng mình em biết",
                "Khắc Việt"
            )
        )
        mSongs.add(
            Song(
                "60698",
                "HÃY TIN ANH LẦN NỮA",
                "Dẫu cho ta đã sai khi ở bên nhau Cố yêu thương",
                "Thiên Dũng"
            )
        )
        mSongs.add(
            Song(
                "60699",
                "CHUỐI NGÀY VẮNG EM",
                "Từ khi em bước ra đi cõi lòng anh ngập tràng bao",
                "Duy Cường"
            )
        )
        mSongs.add(
            Song(
                "60700",
                "KHI NGƯỜI MÌNH YÊU KHÓC",
                "Nước mắt em đang rơi trên những ngón tay tuyết mắt em",
                "Phan Mạnh Quỳnh"
            )
        )
        mSongs.add(
            Song(
                "60701",
                "ANH",
                "Anh nhớ gặp em anh mơ được gần",
                "Trịnh Thăng Bình"
            )
        )
        mSongs.add(
            Song(
                "60702",
                "TÌNH YÊU CHẤP VÁ",
                "Muốn níu xa dĩ vãng thương mình từng có để không nghe",
                "Mr. Siro"
            )
        )
        mSongs.add(
            Song(
                "60703",
                "CHỜ NGÀY MƯA TAN",
                "1 ngày vừa xa em khuất xa nơi anh bóng dáng cũ",
                "Trung Đức"
            )
        )
        mSongs.add(
            Song(
                "60704",
                "CÂU HỎI EM CHƯA TRẢ LỜI",
                "Cần nói em 1 lời giải thích thật lòng Đừng lặng im",
                "Yuki Huy Nam"
            )
        )
        mSongs.add(
            Song(
                "60705",
                "QUA ĐI LẶNG LẼ",
                "Đôi khi đến với nhau yêu thương chẳng được lâu nhưng khi",
                "Phan Mạnh Quỳnh"
            )
        )
        mSongs.add(
            Song(
                "60706",
                "QUÊN ANH LÀ ĐIỀU EM KHÔNG THỂ - REMIX",
                "Cần thêm bao lâu để em quên đi niềm dấu cần thêm",
                "Thiên Ngôn"
            )
        )
    }
}