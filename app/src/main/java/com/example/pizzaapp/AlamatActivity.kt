package com.example.pizzaapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AlamatActivity : AppCompatActivity() {

    private var currentName: String = "Guest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat)
        supportActionBar?.hide()

        currentName = intent.getStringExtra("EXTRA_NAME") ?: "Guest"

        val namaEditText = findViewById<EditText>(R.id.et_full_name_alamat)
        namaEditText.setText(currentName)

        val orderButton = findViewById<Button>(R.id.btn_order_kirim_submit)
        orderButton.setOnClickListener {
            val intent = Intent(this, SuccessActivity::class.java)
            intent.putExtra("EXTRA_NAME", currentName)
            startActivity(intent)
            finish()
        }
    }
}