package com.example.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Sembunyikan ActionBar
        supportActionBar?.hide()

        // --- TAMBAHKAN KODE INI ---

        // 1. Cari tombol Register dan EditText Nama Lengkap
        val registerButton = findViewById<Button>(R.id.btn_register_submit)
        val fullNameEditText = findViewById<EditText>(R.id.et_full_name)

        // 2. Beri aksi klik pada tombol Register
        registerButton.setOnClickListener {
            // Ambil teks dari EditText
            val fullName = fullNameEditText.text.toString()

            // Buat Intent untuk pindah ke HomeActivity
            val intent = Intent(this, HomeActivity::class.java)

            // SELIPKAN "Nama Lengkap" ke dalam Intent
            // Kita beri nama data ini "EXTRA_NAME"
            intent.putExtra("EXTRA_NAME", fullName)

            // Mulai HomeActivity
            startActivity(intent)

            // Selesai (menutup halaman register & login agar tidak bisa kembali)
            finishAffinity()
        }
    }
}
