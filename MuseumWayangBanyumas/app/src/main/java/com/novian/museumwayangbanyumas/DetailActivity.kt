package com.novian.museumwayangbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val urlGambarDetail: ImageView = findViewById(R.id.url_gambar_detail)
        val tvNamaDetail: TextView = findViewById(R.id.tv_nama_detail)
        val tvDeskripsiDetail: TextView = findViewById(R.id.tv_deskripsi_detail)
        val btnKembaliDetail: ImageView = findViewById(R.id.btn_kembali_detail)

        val intent = intent

        // Terima data
        val gambar = intent?.getStringExtra("gambar")
        val nama = intent?.getStringExtra("nama")
        val deskripsi = intent?.getStringExtra("deskripsi")

        // Pasang data
        Glide
            .with(this)
            .load(gambar)
            .into(urlGambarDetail)
        tvNamaDetail.text = nama
        tvDeskripsiDetail.text = deskripsi?.replace("\\n", "\n")


        btnKembaliDetail.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


    }
}