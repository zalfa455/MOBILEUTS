package com.example.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SuccessActivity : AppCompatActivity() {

    private var currentName: String = "Guest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        // 1. Sembunyikan ActionBar
        supportActionBar?.hide()

        // 2. Menerima dan Menampilkan Nama
        currentName = intent.getStringExtra("EXTRA_NAME") ?: "Guest"

        val haloTextView = findViewById<TextView>(R.id.tv_halo_name_success)
        haloTextView.text = "Halo $currentName,"

        // 3. Aksi Tombol "Kirim" (Kembali ke Home)
        val kirimButton = findViewById<Button>(R.id.btn_kirim_success)
        kirimButton.setOnClickListener {
            // Buat intent untuk kembali ke HomeActivity
            val intent = Intent(this, HomeActivity::class.java)

            // Kirim nama kembali ke Home
            intent.putExtra("EXTRA_NAME", currentName)

            // Flag ini akan membersihkan semua activity di atas Home
            // dan meluncurkan Home sebagai activity baru.
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(intent)

            // Menutup semua activity dalam tumpukan (Order, Alamat, Success)
            finishAffinity()
        }
    }
}
