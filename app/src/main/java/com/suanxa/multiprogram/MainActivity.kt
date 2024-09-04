package com.suanxa.multiprogram

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tombol1: Button = findViewById(R.id.pil1)
        tombol1.setOnClickListener {
            val intent = Intent(this, suhu::class.java)
            startActivity(intent)
        }
        val tombol2: Button = findViewById(R.id.pil2)
        tombol2.setOnClickListener {
            val intent = Intent(this, diskon::class.java)
            startActivity(intent)
        }
        val tombol3: Button = findViewById(R.id.pil3)
        tombol3.setOnClickListener {
            val intent = Intent(this, hitung::class.java)
            startActivity(intent)
        }
        val tombol4: Button = findViewById(R.id.pil4)
        tombol4.setOnClickListener {
            val intent = Intent(this, tentukan::class.java)
            startActivity(intent)
        }
    }
}
