package com.example.pizzaapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class OrderActivity : AppCompatActivity() {

    private var currentName: String = "Guest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        supportActionBar?.hide()

        currentName = intent.getStringExtra("EXTRA_NAME") ?: "Guest"

        val haloTextView = findViewById<TextView>(R.id.tv_halo_name_order)
        haloTextView.text = "Hai kak $currentName, Selamat Datang"
        val kirimButton = findViewById<Button>(R.id.btn_kirim)
        kirimButton.setOnClickListener {
            val intent = Intent(this, AlamatActivity::class.java)
            intent.putExtra("EXTRA_NAME", currentName)

            startActivity(intent)
        }

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation_order)
        bottomNav.selectedItemId = R.id.nav_order

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("EXTRA_NAME", currentName)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_order -> {
                    true
                }
                R.id.nav_profile -> {
                    // TODO: Nanti bisa ditambahkan halaman Profile
                    true
                }
                else -> false
            }
        }
    }
}