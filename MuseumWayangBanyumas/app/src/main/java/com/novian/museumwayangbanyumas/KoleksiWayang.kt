package com.novian.museumwayangbanyumas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class KoleksiWayang : AppCompatActivity() {
    // Inisialisasi
    private lateinit var wAdapter : WayangAdapter
    private lateinit var ref : DatabaseReference
    private lateinit var wayangList : ArrayList<Wayang>
    private lateinit var rvKoleksi : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koleksi_wayang)

        rvKoleksi = findViewById(R.id.rv_koleksi)

        wayangList = ArrayList()
        wAdapter = WayangAdapter(this, wayangList)
        rvKoleksi.layoutManager = LinearLayoutManager(this)
        rvKoleksi.setHasFixedSize(true)
        rvKoleksi.adapter = wAdapter

        //Panggil Data Firebase
        getDataWayang()

    }

    private fun getDataWayang() {
        // Tag pada firebase
        ref = FirebaseDatabase.getInstance().getReference("Wayang")
        ref.addValueEventListener(object : ValueEventListener{
            // Setiap ada perubahan data, akan membuat list baru
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    wayangList.clear() // menghapus list sebelumnya, biar gak double (ketika tambah data)
                    for (wayangSnapshot in snapshot.children){
                        val wayang = wayangSnapshot.getValue(Wayang::class.java)
                        if (wayang != null) {
                            wayangList.add(wayang)
                        }
                    }
                    rvKoleksi.adapter = wAdapter
                    //val adapter = MahasiswaAdapter(applicationContext, R.layout.item_mhs, mhsList)
                    //listMhs.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@KoleksiWayang,error.message, Toast.LENGTH_SHORT).show()
            }

        })
    }



}