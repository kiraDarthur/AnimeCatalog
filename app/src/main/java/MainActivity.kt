package com.example.animecatalog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerAnimes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerAnimes = findViewById(R.id.recyclerAnimes)

        recyclerAnimes.layoutManager = LinearLayoutManager(this)

        recyclerAnimes.adapter = AnimeAdapter(AnimeData.listaAnimes) { anime ->

            val intent = Intent(this, ReviewActivity::class.java)

            intent.putExtra("anime", anime)

            startActivity(intent)
        }
    }
}