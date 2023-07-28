package com.novian.museumwayangbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class ScanDetailActivity : AppCompatActivity() {

    private lateinit var database: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_detail)

        val btnKembaliScanDetail: ImageView = findViewById(R.id.btn_kembali_scan_detail)

        btnKembaliScanDetail.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        val url_gambar_detail_scan = findViewById<ImageView>(R.id.url_gambar_detail_scan)
        val tv_nama_detail_scan = findViewById<TextView>(R.id.tv_nama_detail_scan)
        val tv_deskripsi_detail_scan = findViewById<TextView>(R.id.tv_deskripsi_detail_scan)

        // Terima data
        val gambar = intent?.getStringExtra("gambar")
        val nama = intent?.getStringExtra("nama")
        val deskripsi = intent?.getStringExtra("deskripsi")

        // Pasang data
        Glide
            .with(this)
            .load(gambar)
            .into(url_gambar_detail_scan)
        tv_nama_detail_scan.text = nama
        tv_deskripsi_detail_scan.text = deskripsi?.replace("\\n", "\n")

    }
}