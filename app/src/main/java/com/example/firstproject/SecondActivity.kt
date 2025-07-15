package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.util.Patterns

class SecondActivity : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonContinue = findViewById(R.id.buttonContinue)

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                buttonContinue.isEnabled = validateEmail() && validatePassword()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        editTextEmail.addTextChangedListener(textWatcher)
        editTextPassword.addTextChangedListener(textWatcher)

        buttonContinue.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra("email", email)
                putExtra("password", password)
            }
            startActivity(intent)
        }
    }

    private fun validateEmail(): Boolean {
        val emailText = editTextEmail.text.toString()
        return emailText.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
    }

    private fun validatePassword(): Boolean {
        val passwordText = editTextPassword.text.toString()
        if (passwordText.length < 8) return false
        if (!passwordText.any { it.isDigit() }) return false
        if (!passwordText.any { it.isLowerCase() }) return false
        if (!passwordText.any { it.isUpperCase() }) return false
        return true
    }
}
