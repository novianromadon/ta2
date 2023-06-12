package com.novian.museumwayangbanyumas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = ArrayList<SlideModel>() // Buat image list slider

        // imageList.add(SlideModel("String Url" or R.drawable)
        // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        // Buat ganti gambar slider
        imageList.add(SlideModel(R.drawable.slide1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide3, ScaleTypes.FIT))

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        val btnScanBarcode = findViewById<Button>(R.id.btnScanBarcode)
        val btnKoleksiWayang = findViewById<Button>(R.id.btnKoleksiWayang)
        val btnSejarahWayang = findViewById<Button>(R.id.btnSejarahWayang)
        val btnTentang = findViewById<Button>(R.id.btnTentang)

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