package com.example.smartwatch

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChatListActivity : AppCompatActivity() {

    private val chats = arrayListOf("Lucifer", "The Witcher", "LOST", "The Magicians")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)

        val lvChats = findViewById<ListView>(R.id.lvChats)
        val adapter = ArrayAdapter<String>(this, R.layout.item_chat, chats)
        lvChats.adapter = adapter

        lvChats.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@ChatListActivity, chats[position], Toast.LENGTH_SHORT).show()
            }
        }
    }
}