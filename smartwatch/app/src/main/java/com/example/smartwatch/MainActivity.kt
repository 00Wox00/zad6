package com.example.smartwatch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChats = findViewById<LinearLayout>(R.id.btnChats)
        val btnNew = findViewById<LinearLayout>(R.id.btnNew)
        val btnFavorites = findViewById<LinearLayout>(R.id.btnFavorites)

        btnChats.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@MainActivity, ChatListActivity::class.java))
            }
        })

        btnNew.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                startActivity(Intent(this@MainActivity, MoviesActivity::class.java))
            }
        })

        btnFavorites.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(this@MainActivity, "Избранное пока пусто", Toast.LENGTH_SHORT).show()
            }
        })
    }
}