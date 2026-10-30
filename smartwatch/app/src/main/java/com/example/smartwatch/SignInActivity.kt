package com.example.smartwatch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnSignIn = findViewById<TextView>(R.id.btnSignIn)

        btnSignIn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val email = etEmail.text.toString().trim()
                val password = etPassword.text.toString()
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this@SignInActivity, "Введите e-mail и пароль", Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                    finish()
                }
            }
        })
    }
}