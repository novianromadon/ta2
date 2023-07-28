package com.novian.museumwayangbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class KoleksiWayang : AppCompatActivity() {
    // Inisialisasi
    var db = Firebase.firestore
    private lateinit var wayangList : ArrayList<Wayang>
    private lateinit var rvKoleksi : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koleksi_wayang)

        val btnKembaliKoleksi: ImageView = findViewById(R.id.btn_kembali_koleksi)

        btnKembaliKoleksi.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        rvKoleksi = findViewById(R.id.rv_koleksi)
        wayangList = ArrayList()

        //Panggil Data Firebase
        getDataWayang()

    }

    private fun getDataWayang() {
        db.collection("Wayang")
            .get()
            .addOnSuccessListener {
                wayangList.clear()      // menghapus list sebelumnya, biar gak double (ketika tambah data)

                for (document in it) {
                    wayangList.add((Wayang(
                        document.id as String,
                        document.data.get("gambar")as String,
                        document.data.get("nama")as String,
                        document.data.get("deskripsi")as String,
                    )))
                }

                var wayangAdapter = WayangAdapter(this,wayangList)
                rvKoleksi.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = wayangAdapter
                }
            }
            .addOnFailureListener {
                Log.v("cek", "Gagal Mengambil Data")
            }
    }
}