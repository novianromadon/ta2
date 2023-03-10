package com.novian.museumwayangbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}