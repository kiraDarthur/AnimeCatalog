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

    private lateinit var txtAnimeNome: TextView
    private lateinit var imgAnime: ImageView

    private lateinit var edtNota: EditText
    private lateinit var edtPersonagem: EditText
    private lateinit var edtGenero: EditText
    private lateinit var edtEpisodios: EditText
    private lateinit var edtOpiniao: EditText
    private lateinit var edtData: EditText

    private lateinit var btnGuardar: Button

    private var anime: Anime? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        txtAnimeNome = findViewById(R.id.txtAnimeNome)
        imgAnime = findViewById(R.id.imgAnime)

        edtNota = findViewById(R.id.edtNota)
        edtPersonagem = findViewById(R.id.edtPersonagem)
        edtGenero = findViewById(R.id.edtGenero)
        edtEpisodios = findViewById(R.id.edtEpisodios)
        edtOpiniao = findViewById(R.id.edtOpiniao)
        edtData = findViewById(R.id.edtData)

        btnGuardar = findViewById(R.id.btnGuardar)

        anime =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra("anime", Anime::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getSerializableExtra("anime") as? Anime
            }

        if (anime != null) {
            txtAnimeNome.text = anime!!.nome
            imgAnime.setImageResource(anime!!.imagem)
        }

        btnGuardar.setOnClickListener {

            if (edtNota.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Digite uma nota!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            anime?.nota = edtNota.text.toString().toDoubleOrNull() ?: 0.0
            anime?.personagem = edtPersonagem.text.toString()
            anime?.genero = edtGenero.text.toString()
            anime?.episodios = edtEpisodios.text.toString().toIntOrNull() ?: 0
            anime?.opiniao = edtOpiniao.text.toString()
            anime?.data = edtData.text.toString()

            AvaliacoesData.listaAvaliacoes.add(anime!!)

            Toast.makeText(
                this,
                "Avaliação guardada com sucesso!",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(
                Intent(
                    this,
                    ListaActivity::class.java
                )
            )

            finish()
        }
    }
}