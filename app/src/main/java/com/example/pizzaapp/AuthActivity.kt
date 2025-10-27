package com.example.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // Sembunyikan ActionBar
        supportActionBar?.hide()

        // --- Implementasi Navigasi ---

        // 1. Cari tombol Register dan Login berdasarkan ID-nya
        // Pastikan ID ini (`btn_register` dan `btn_login`) ada di activity_auth.xml
        val registerButton = findViewById<Button>(R.id.btn_register)
        val loginButton = findViewById<Button>(R.id.btn_login)

        // 2. Tambahkan aksi klik untuk tombol Register
        registerButton.setOnClickListener {
            // Buat Intent untuk pindah ke RegisterActivity
            // Pastikan Anda sudah membuat RegisterActivity.kt
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // 3. Tambahkan aksi klik untuk tombol Login
        loginButton.setOnClickListener {
            // Buat Intent untuk pindah ke LoginActivity
            // Pastikan Anda sudah membuat LoginActivity.kt
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
