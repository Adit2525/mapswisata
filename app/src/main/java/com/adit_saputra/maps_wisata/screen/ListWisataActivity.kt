package com.adit_saputra.maps_wisata.screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adit_saputra.maps_wisata.Adapter.wisataAdapter
import com.adit_saputra.maps_wisata.Model.model_wisata
import com.adit_saputra.maps_wisata.R

class ListWisataActivity : AppCompatActivity() {

    private lateinit var rvListWisata: RecyclerView
    private lateinit var wisataAdapter: wisataAdapter
    private val wisataList = mutableListOf<model_wisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        rvListWisata = findViewById(R.id.rv_list_wisata)
        wisataAdapter = wisataAdapter(wisataList)
        rvListWisata.layoutManager = GridLayoutManager(this, 1)
        rvListWisata.adapter = wisataAdapter

        prepareDataWisata()
    }

    private fun prepareDataWisata() {
        var wisata = model_wisata(
            R.drawable.gambar6,
            "sydney",
            "australia",
            -0.9494, 100.3558 // Latitude and Longitude for Masjid Raya
        )
        wisataList.add(wisata)

        wisata = model_wisata(
            R.drawable.gambar2,
            "Maninjau",
            "Tanah Datar",
            -8.4033, 100.2704 // Latitude and Longitude for Maninjau
        )
        wisataList.add(wisata)

        wisata = model_wisata(
            R.drawable.gambar1,
            "Arau",
            "Lima Puluh Kota",
            -0.2977, 100.3752 // Latitude and Longitude for Arau
        )
        wisataList.add(wisata)

        wisata = model_wisata(
            R.drawable.gambar4,
            "Ngarai Sianok",
            "Bukittinggi",
            -0.2221, 100.3682 // Latitude and Longitude for Ngarai Sianok
        )
        wisataList.add(wisata)

        wisata = model_wisata(
            R.drawable.gambar5,
            "Pagaruyuang",
            "Limapuluh Kota",
            -0.2977, 100.3752 // Latitude and Longitude for Pagaruyuang
        )
        wisataList.add(wisata)

        // Notify the adapter about data changes
        wisataAdapter.notifyDataSetChanged()
    }
}
