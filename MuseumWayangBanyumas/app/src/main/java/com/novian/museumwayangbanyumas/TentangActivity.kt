package com.novian.museumwayangbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TentangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)

        val btnKembaliTentang: ImageView = findViewById(R.id.btn_kembali_tentang)

        btnKembaliTentang.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}