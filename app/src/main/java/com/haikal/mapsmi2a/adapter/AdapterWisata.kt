package com.haikal.mapsmi2a.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.haikal.mapsmi2a.R
import com.haikal.mapsmi2a.model.ModelWisata

class AdapterWisata(
    // data diambil dari model
    val listItemWisata: List<ModelWisata>
): RecyclerView.Adapter<AdapterWisata.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // layout pada widget
        val gambarWisata: ImageView = itemView.findViewById(R.id.gambarWisata)
        val namaLokasiWisata: TextView = itemView.findViewById(R.id.namaLokasiWisata)
        val alamatWisata: TextView = itemView.findViewById(R.id.alamatWisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_wisata, parent, false)

        return MyViewHolder(nView)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = listItemWisata[position]
        // pertama dari id, yang kedua dari model
        holder.gambarWisata.setImageResource(currentItem.gambarWisata)
        holder.namaLokasiWisata.text = currentItem.namaLokasiWisata
        holder.alamatWisata.text = currentItem.alamatWisata
    }

    override fun getItemCount(): Int {
        return listItemWisata.size
    }
}