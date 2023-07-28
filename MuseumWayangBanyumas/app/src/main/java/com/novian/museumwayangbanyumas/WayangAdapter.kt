package com.novian.museumwayangbanyumas

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class WayangAdapter(private val context : Context, private var wayangList :ArrayList<Wayang>) :
    RecyclerView.Adapter<WayangAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val urlGambar : ImageView = itemView.findViewById(R.id.url_gambar)
        val tvNama : TextView = itemView.findViewById(R.id.tv_nama)
        val tvDeskripsi : TextView = itemView.findViewById(R.id.tv_deskripsi)
        val cvItem : CardView = itemView.findViewById(R.id.cv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_wayang, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (id, gambar, nama, deskripsi) = wayangList[position]
        Glide
            .with(context)
            .load(gambar)
            .into(holder.urlGambar)

        holder.tvNama.text = nama
        holder.tvDeskripsi.text = deskripsi

        // Ke halaman detail
        holder.cvItem.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)

            intent.putExtra("gambar", gambar)
            intent.putExtra("nama", nama)
            intent.putExtra("deskripsi", deskripsi)

            it.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = wayangList.size


}