package com.example.animecatalog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

            val nota = edtNota.text.toString().toDoubleOrNull()

            if (nota == null || nota < 0 || nota > 10) {
                Toast.makeText(
                    this,
                    "A nota deve ser entre 0 e 10.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val avaliacao = Avaliacao(
                anime,
                nota,
                edtPersonagem.text.toString(),
                edtGenero.text.toString(),
                edtEpisodios.text.toString(),
                edtOpiniao.text.toString(),
                edtData.text.toString()
            )

            AvaliacoesData.listaAvaliacoes.add(avaliacao)

            Toast.makeText(
                this,
                "Avaliação guardada com sucesso!",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}