package com.novian.museumwayangbanyumas

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class DetailActivity : AppCompatActivity() {

    private lateinit var ref : DatabaseReference
    private lateinit var wayangList : ArrayList<Wayang>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val url_gambar_detail = findViewById<ImageView>(R.id.url_gambar_detail)
        val tv_nama_detail = findViewById<TextView>(R.id.tv_nama_detail)
        val tv_deskripsi_detail = findViewById<TextView>(R.id.tv_deskripsi_detail)

        val intent = intent

        // Terima data
        val gambar = intent?.getStringExtra("gambar")
        val nama = intent?.getStringExtra("nama")
        val deskripsi = intent?.getStringExtra("deskripsi")
        val hasilQR = intent?.getStringExtra("hasilQR") // Dari Scan QR

        // Pasang data
        Glide
            .with(this)
            .load(gambar)
            .into(url_gambar_detail)
        tv_nama_detail.text = nama
        tv_deskripsi_detail.text = deskripsi

        //val docRef2 = database.collection("products").document(qrText!!)

        ref = FirebaseDatabase.getInstance().getReference("Wayang")
        ref.setValue(hasilQR!!).addOnSuccessListener {
            ref.get().addOnSuccessListener {
                val getValue = it.getValue(Wayang::class.java)
                if (getValue != null) {
                    val UrlGambar = getValue.gambar
                    val Nama = getValue.nama
                    val Deskripsi = getValue.deskripsi

                    Glide
                        .with(this)
                        .load(UrlGambar)
                        .into(url_gambar_detail)
                    tv_nama_detail.text = Nama
                    tv_deskripsi_detail.text = Deskripsi
                }
            }
        }




/**
        ref.child("id").addValueEventListener(object : ValueEventListener{
            // Setiap ada perubahan data, akan membuat list baru
            override fun onDataChange(snapshot: DataSnapshot) {
                val post = snapshot.getValue<Wayang>()
                if (post != null) {
                    val nombreProducto = "gambar" as String?
                    val descripcionProducto = "nama" as String?
                    val imagenProducto = "deskripsi" as String?
                }


            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@DetailActivity,error.message, Toast.LENGTH_SHORT).show()
            }

        }) */









/**
        ref.child("Wayang").setValue(hasilQR!!).addOnSuccessListener {

            Glide
                .with(this)
                .load(gambar)
                .into(url_gambar_detail)
            tv_nama_detail.text = nama
            tv_deskripsi_detail.text = deskripsi

        } */


    }
}