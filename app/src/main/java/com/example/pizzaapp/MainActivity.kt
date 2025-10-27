package com.example.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sembunyikan ActionBar
        supportActionBar?.hide()

        // Cari tombol "Start now" berdasarkan ID-nya
        val startButton = findViewById<Button>(R.id.btn_start_now)

        // Tambahkan aksi klik pada tombol
        startButton.setOnClickListener {
            // Buat Intent untuk pindah dari MainActivity ke AuthActivity
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }
}