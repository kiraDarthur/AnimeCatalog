package com.example.animecatalog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_review)

        val anime = intent.getSerializableExtra("anime") as Anime

        val imagem = findViewById<ImageView>(R.id.imgAnime)
        val titulo = findViewById<TextView>(R.id.txtAnimeNome)

        imagem.setImageResource(anime.imagem)
        titulo.text = anime.nome

        val edtNota = findViewById<EditText>(R.id.edtNota)
        val edtPersonagem = findViewById<EditText>(R.id.edtPersonagem)
        val edtGenero = findViewById<EditText>(R.id.edtGenero)
        val edtEpisodios = findViewById<EditText>(R.id.edtEpisodios)
        val edtOpiniao = findViewById<EditText>(R.id.edtOpiniao)
        val edtData = findViewById<EditText>(R.id.edtData)

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener {

            val intent = Intent(this, ListaActivity::class.java)

            startActivity(intent)

        }

    }

}