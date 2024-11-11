package com.adit_saputra.maps_wisata.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.adit_saputra.maps.detailWisata
import com.adit_saputra.maps_wisata.Model.model_wisata
import com.adit_saputra.maps_wisata.R


class wisataAdapter(
    private val itemWisatalist: List<model_wisata>
) : RecyclerView.Adapter<wisataAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgWisata: ImageView = itemView.findViewById(R.id.imgWisata)
        val txtNamaWisata: TextView = itemView.findViewById(R.id.txtNamaWisata)
        val txtLokasiWisata: TextView = itemView.findViewById(R.id.txtLokasiWisata)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_wisata, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemWisatalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemWisatalist[position]
        holder.imgWisata.setImageResource(currentItem.imgWisata)
        holder.txtNamaWisata.text = currentItem.NamaWisata
        holder.txtLokasiWisata.text = currentItem.LokasiWisata

        holder.itemView.setOnClickListener {
            // Declare intent
            val intent = Intent(holder.itemView.context, detailWisata::class.java)
            // Put Extra
            intent.putExtra("ImgWisata", currentItem.imgWisata)
            intent.putExtra("NamaWisata", currentItem.NamaWisata)
            intent.putExtra("LokasiWisata", currentItem.LokasiWisata)

            // Add latitude and longitude
            intent.putExtra("latitude", currentItem.latWisata)
            intent.putExtra("longitude", currentItem.longWisata)

            // Start DetailWisata activity
            holder.itemView.context.startActivity(intent)

            // Show Toast message
            Toast.makeText(holder.itemView.context, currentItem.NamaWisata, Toast.LENGTH_SHORT).show()
        }
    }
}
