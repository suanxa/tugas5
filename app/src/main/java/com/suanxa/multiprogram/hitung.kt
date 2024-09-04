package com.suanxa.multiprogram

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class hitung : AppCompatActivity() {

    private lateinit var inputPanjang: EditText
    private lateinit var inputLebar: EditText
    private lateinit var inputTinggi: EditText
    private lateinit var textHasilLuas: TextView
    private lateinit var textHasilVolume: TextView
    private lateinit var buttonHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung)

        inputPanjang = findViewById(R.id.input1)
        inputLebar = findViewById(R.id.input2)
        inputTinggi = findViewById(R.id.input3)
        textHasilLuas = findViewById(R.id.textHasil1)
        textHasilVolume = findViewById(R.id.textHasil2)
        buttonHitung = findViewById(R.id.buttonCari)

        buttonHitung.setOnClickListener {
            hitung()
        }
    }

    private fun hitung() {
        val panjang = inputPanjang.text.toString().toDoubleOrNull()
        val lebar = inputLebar.text.toString().toDoubleOrNull()
        val tinggi = inputTinggi.text.toString().toDoubleOrNull()

        if (panjang != null && lebar != null && tinggi != null) {
            val luasPermukaan = 2 * (panjang * lebar + lebar * tinggi + tinggi * panjang)
            val volume = panjang * lebar * tinggi

            textHasilLuas.text = "Luas Permukaan: ${String.format("%.2f", luasPermukaan)}"
            textHasilVolume.text = "Volume: ${String.format("%.2f", volume)}"
        } else {
            textHasilLuas.text = "Masukkan nilai yang valid."
            textHasilVolume.text = ""
        }
    }
}
