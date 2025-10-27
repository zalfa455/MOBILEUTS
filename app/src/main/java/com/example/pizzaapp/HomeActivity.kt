package com.example.pizzaapp


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private var currentName: String = "Guest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        currentName = intent.getStringExtra("EXTRA_NAME") ?: "Guest"

        val haloTextView = findViewById<TextView>(R.id.tv_halo_name)
        haloTextView.text = "Hai kak $currentName, Selamat Datang"

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_home

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_order -> {
                    val intent = Intent(this, OrderActivity::class.java)
                    intent.putExtra("EXTRA_NAME", currentName)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_profile -> true
                else -> false
            }
        }
    }
}