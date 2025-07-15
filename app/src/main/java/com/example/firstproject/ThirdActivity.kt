package com.example.firstproject

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        val textViewPassword = findViewById<TextView>(R.id.textViewPassword)

        textViewEmail.text = "E-mail: $email"
        textViewPassword.text = "Пароль: $password"
    }
}
