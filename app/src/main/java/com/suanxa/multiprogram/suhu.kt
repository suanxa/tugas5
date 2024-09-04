package com.suanxa.multiprogram

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class suhu : AppCompatActivity() {

    private lateinit var input: EditText
    private lateinit var pilihan: Spinner
    private lateinit var hasil: TextView
    private lateinit var tombol: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suhu)

        input = findViewById(R.id.input1)
        pilihan = findViewById(R.id.pilihan1)
        hasil = findViewById(R.id.txtHasil)
        tombol = findViewById(R.id.konversi)

        val temperatureUnits = arrayOf("Celsius", "Fahrenheit", "Kelvin", "Reamur")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, temperatureUnits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        pilihan.adapter = adapter

        tombol.setOnClickListener {
            convertTemperature()
        }
    }

    private fun convertTemperature() {
        val temperatureInput = input.text.toString()
        val selectedUnit = pilihan.selectedItem.toString()
        val celsius: Double? = temperatureInput.toDoubleOrNull()

        if (celsius != null) {
            val result = when (selectedUnit) {
                "Celsius" -> {
                    "Fahrenheit: %.2f\nKelvin: %.2f\nReamur: %.2f".format(
                        (9.0 / 5.0) * celsius + 32,
                        celsius + 273.15,
                        (4.0 / 5.0) * celsius
                    )
                }
                "Fahrenheit" -> {
                    val celsiusValue = (celsius - 32) * 5.0 / 9.0
                    "Celsius: %.2f\nKelvin: %.2f\nReamur: %.2f".format(
                        celsiusValue,
                        celsiusValue + 273.15,
                        (4.0 / 5.0) * celsiusValue
                    )
                }
                "Kelvin" -> {
                    val celsiusValue = celsius - 273.15
                    "Celsius: %.2f\nFahrenheit: %.2f\nReamur: %.2f".format(
                        celsiusValue,
                        (9.0 / 5.0) * celsiusValue + 32,
                        (4.0 / 5.0) * celsiusValue
                    )
                }
                "Reamur" -> {
                    val celsiusValue = (5.0 / 4.0) * celsius
                    "Celsius: %.2f\nFahrenheit: %.2f\nKelvin: %.2f".format(
                        celsiusValue,
                        (9.0 / 5.0) * celsiusValue + 32,
                        celsiusValue + 273.15
                    )
                }
                else -> "Satuan suhu tidak dikenali"
            }

            hasil.text = "Hasil = \n$result"
        } else {
            hasil.text = "Hasil = Masukkan suhu yang valid"
        }
    }
}
