package com.novian.museumwayangbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SejarahActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sejarah)

        val btnKembaliSejarah: ImageView = findViewById(R.id.btn_kembali_sejarah)

        btnKembaliSejarah.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}