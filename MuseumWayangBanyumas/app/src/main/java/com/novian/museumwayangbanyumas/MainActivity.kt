package com.novian.museumwayangbanyumas

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cek Koneksi Internet
        val connectionManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnectedOrConnecting == true) {

        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Status Koneksi")
            builder.setMessage("Harap pastikan koneksi internet Anda terhubung")
            builder.show()
        }

        val imageList = ArrayList<SlideModel>() // Buat image list slider

        // Buat ganti gambar slider
        imageList.add(SlideModel(R.drawable.slide1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide3, ScaleTypes.FIT))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        val btnScanBarcode = findViewById<CardView>(R.id.btnScanBarcode)
        val btnKoleksiWayang = findViewById<CardView>(R.id.btnKoleksiWayang)
        val btnSejarahWayang = findViewById<CardView>(R.id.btnSejarahWayang)
        val btnTentang = findViewById<CardView>(R.id.btnTentang)

        // Klik Barcode
        btnScanBarcode.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, LayarScan::class.java)
            startActivity(intent)
        })

        // Klik Koleksi Wayang
        btnKoleksiWayang.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, KoleksiWayang::class.java)
            startActivity(intent)
        })

        // Klik Sejarah Wayang
        btnSejarahWayang.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SejarahActivity::class.java)
            startActivity(intent)
        })

        // Klik Tentang
        btnTentang.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, TentangActivity::class.java)
            startActivity(intent)
        })
    }
}