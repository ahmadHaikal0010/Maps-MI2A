package com.haikal.mapsmi2a

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haikal.mapsmi2a.adapter.AdapterWisata
import com.haikal.mapsmi2a.model.ModelWisata

class ListWisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        // data list wisata
        val listWisata = listOf<ModelWisata>(
            ModelWisata(
                "Bali",
                "Bali",
                R.drawable.wisata1,
                "Bali",
                -8.4535604,
                114.4120822
            ),
            ModelWisata(
                "Pantai Lombok",
                "Lombok",
                R.drawable.wisata2,
                "Lombok",
                -8.5822965,
                115.9433307
            ),
            ModelWisata(
                "Pantai Balekambang",
                "Jawa Timur",
                R.drawable.wisata3,
                "Jawa Timur",
                -8.4035603,
                112.5342213
            ),
            ModelWisata(
                "Air Terjun Pemuteran",
                "Bali",
                R.drawable.wisata4,
                "Bali",
                -8.1704875,
                114.6078781
            )
        )

        // panggil adapter
        val adapterWisata = AdapterWisata(listWisata)

        // recycler view
        val rv_wisata: RecyclerView = findViewById(R.id.rv_wisata)
        rv_wisata.adapter = adapterWisata

        // set layout untuk recycler view
        rv_wisata.apply {
            layoutManager = LinearLayoutManager(this@ListWisataActivity)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}