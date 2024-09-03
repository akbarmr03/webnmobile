package com.example.my

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nama: EditText=findViewById(R.id.nama)
        val username: EditText=findViewById(R.id.username)
        val tombol: Button=findViewById(R.id.btn_submit)
        val gender: Spinner=findViewById(R.id.gender)
        val choose: Button=findViewById(R.id.calendar)
        val tgllahir: EditText=findViewById(R.id.tgllahir)
            val items = listOf("Laki-Laki", "Perempuan")
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            gender.adapter = adapter


        tombol.setOnClickListener {
            val kumpul=nama.text.toString()
            val kumpul1=username.text.toString()
            Toast.makeText(this, kumpul+kumpul1, Toast.LENGTH_SHORT).show()
        }

       

        choose.setOnClickListener {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    DatePickerDialog(
        this,
        { _, year1, month1, dayOfMonth ->
            val date = "$dayOfMonth/${month1 + 1}/$year1"
            tgllahir.setText(date)
        },
        year,
        month,
        day
    ).show()
}

    }
}