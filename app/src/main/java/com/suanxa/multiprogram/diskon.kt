package com.suanxa.multiprogram

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class diskon : AppCompatActivity() {

    private lateinit var inputBelanja: EditText
    private lateinit var textHasil: TextView
    private lateinit var buttonHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diskon)

        inputBelanja = findViewById(R.id.inputDiskon)
        textHasil = findViewById(R.id.textHasil)
        buttonHitung = findViewById(R.id.buttonCari)

        buttonHitung.setOnClickListener {
            hitungDiskon()
        }
    }

    private fun hitungDiskon() {
        val totalBelanja = inputBelanja.text.toString().toDoubleOrNull()

        if (totalBelanja != null) {
            val diskon: Double
            val diskonText: String
            when {
                totalBelanja < 100_000 -> {
                    diskon = 0.0
                    diskonText = "Anda tidak mendapatkan diskon."
                }
                totalBelanja in 100_000.0..500_000.0 -> {
                    diskon = 0.10
                    diskonText = "Diskon 10% berlaku."
                }
                totalBelanja in 500_000.0..1_000_000.0 -> {
                    diskon = 0.20
                    diskonText = "Diskon 20% berlaku."
                }
                totalBelanja > 1_000_000.0 -> {
                    diskon = 0.30
                    diskonText = "Diskon 30% berlaku."
                }
                else -> {
                    diskon = 0.0
                    diskonText = "Anda tidak mendapatkan diskon."
                }
            }

            val jumlahDiskon = totalBelanja * diskon
            val setelahDiskon = totalBelanja - jumlahDiskon

            val hasil = "$diskonText\nDiskon: Rp ${jumlahDiskon.toInt()}\nBayar: Rp ${setelahDiskon.toInt()}"

            textHasil.text = hasil
        } else {
            textHasil.text = "Masukkan total belanja yang valid."
        }
    }
}
