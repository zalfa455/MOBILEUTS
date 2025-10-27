package com.example.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Sembunyikan ActionBar
        supportActionBar?.hide()

        // --- TAMBAHKAN KODE INI ---

        // 1. Cari tombol Login dan EditText Username
        val loginButton = findViewById<Button>(R.id.btn_login_submit)
        val usernameEditText = findViewById<EditText>(R.id.et_username)

        // 2. Beri aksi klik pada tombol Login
        loginButton.setOnClickListener {
            // Ambil teks dari EditText
            val username = usernameEditText.text.toString()

            // Buat Intent untuk pindah ke HomeActivity
            val intent = Intent(this, HomeActivity::class.java)

            // SELIPKAN "Username" ke dalam Intent
            // Kita gunakan key yang sama "EXTRA_NAME"
            intent.putExtra("EXTRA_NAME", username)

            // Mulai HomeActivity
            startActivity(intent)

            // Selesai (menutup halaman register & login agar tidak bisa kembali)
            finishAffinity()
        }
    }
}
