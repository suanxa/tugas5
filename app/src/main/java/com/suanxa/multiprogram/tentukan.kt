package com.suanxa.multiprogram

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class tentukan: AppCompatActivity() {

    private lateinit var inputNumber: EditText
    private lateinit var outputResult: TextView
    private lateinit var buttonTentukan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentukan)

        inputNumber = findViewById(R.id.inputNumber)
        outputResult = findViewById(R.id.outputResult)
        buttonTentukan = findViewById(R.id.buttonTentukan)

        buttonTentukan.setOnClickListener {
            tentukanBilangan()
        }
    }

    private fun tentukanBilangan() {
        val number = inputNumber.text.toString().toIntOrNull()

        if (number != null) {
            val result = if (number % 2 == 0) {
                "Bilangan ${number} adalah Genap"
            } else {
                "Bilangan ${number} adalah Ganjil"
            }
            outputResult.text = result
        } else {
            outputResult.text = "Masukkan bilangan yang valid."
        }
    }
}
