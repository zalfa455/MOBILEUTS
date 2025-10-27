package com.example.pizzaapp

import android.content.Intent // Import ditambahkan
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    // Variabel untuk menyimpan nama agar bisa dikirim ke halaman lain
    private var currentName: String = "Guest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()

        // Mengambil nama dan menyimpannya di variabel class
        currentName = intent.getStringExtra("EXTRA_NAME") ?: "Guest"

        // Menampilkan pesan selamat datang kustom Anda
        val haloTextView = findViewById<TextView>(R.id.tv_halo_name)
        haloTextView.text = "Hai kak $currentName, Selamat Datang"

        // Mengatur Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_home

        // --- IMPLEMENTASI NAVIGASI ---
        // Menambahkan listener untuk mengatur perpindahan halaman
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Kita sudah di halaman Home, tidak perlu lakukan apa-apa
                    true
                }
                R.id.nav_order -> {
                    // Pindah ke OrderActivity
                    val intent = Intent(this, OrderActivity::class.java)
                    // Mengirim nama yang sudah disimpan ke OrderActivity
                    intent.putExtra("EXTRA_NAME", currentName)
                    startActivity(intent)
                    // Mencegah animasi transisi antar activity
                    overridePendingTransition(0, 0)
                    // Menutup HomeActivity agar tidak menumpuk
                    finish()
                    true
                }
                R.id.nav_profile -> {
                    // TODO: Implementasikan perpindahan ke ProfileActivity nanti
                    true
                }
                else -> false
            }
        }
    }
}

