package com.example.animecatalog

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detalhes)

        val posicao = intent.getIntExtra("posicao", -1)

        if (posicao == -1) {
            finish()
            return
        }

        val avaliacao = AvaliacoesData.listaAvaliacoes[posicao]

        val imgAnime = findViewById<ImageView>(R.id.imgAnime)
        val txtTitulo = findViewById<TextView>(R.id.txtTitulo)
        val txtNota = findViewById<TextView>(R.id.txtNota)
        val txtPersonagem = findViewById<TextView>(R.id.txtPersonagem)
        val txtGenero = findViewById<TextView>(R.id.txtGenero)
        val txtEpisodios = findViewById<TextView>(R.id.txtEpisodios)
        val txtOpiniao = findViewById<TextView>(R.id.txtOpiniao)
        val txtData = findViewById<TextView>(R.id.txtData)

        imgAnime.setImageResource(avaliacao.anime.imagem)
        txtTitulo.text = avaliacao.anime.nome
        txtNota.text = avaliacao.nota.toString()
        txtPersonagem.text = avaliacao.personagem
        txtGenero.text = avaliacao.genero
        txtEpisodios.text = avaliacao.episodios
        txtOpiniao.text = avaliacao.opiniao
        txtData.text = avaliacao.data
    }
}