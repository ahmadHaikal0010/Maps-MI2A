package com.haikal.mapsmi2a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.haikal.mapsmi2a.databinding.ActivityDetailWisataMapsBinding

class DetailWisataMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityDetailWisataMapsBinding
    private lateinit var nama_lokasi_wisata: TextView
    private lateinit var gambar_wisata: ImageView
    private lateinit var deskripsi_wisata: TextView
    private lateinit var btn_lokasi_wisata: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailWisataMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nama_lokasi_wisata = findViewById(R.id.nama_lokasi_wisata)
        gambar_wisata = findViewById(R.id.gambar_wisata)
        deskripsi_wisata = findViewById(R.id.deskripsi_wisata)
        btn_lokasi_wisata = findViewById(R.id.btn_lokasi_wisata)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // mengambil data dari intent
        val namaLokasiWisata = intent.getStringExtra("namaLokasiWisata")
        val gambarWisata = intent.getIntExtra("gambarWisata", 0)
        val deskripsiWisata = intent.getStringExtra("deskripsiWisata")
        val lattitude = intent.getDoubleExtra("lattitude", 0.0)
        val longitude = intent.getDoubleExtra("longitude", 0.0)

        nama_lokasi_wisata.text = namaLokasiWisata
        gambar_wisata.setImageResource(gambarWisata)
        deskripsi_wisata.text = deskripsiWisata

        // event click button
        btn_lokasi_wisata.setOnClickListener() {
            val intentMapWisata = Intent(this, MapsWisataActivity::class.java)
            intentMapWisata.putExtra("lattitude", lattitude)
            intentMapWisata.putExtra("longitude", longitude)
            intentMapWisata.putExtra("namaLokasiWisata", namaLokasiWisata)
            startActivity(intentMapWisata)
        }

        // Add a marker in Sydney and move the camera
        val koordinatWisata = LatLng(lattitude, longitude)
        mMap.addMarker(MarkerOptions().position(koordinatWisata).title(namaLokasiWisata))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(koordinatWisata, 14F))
    }
}