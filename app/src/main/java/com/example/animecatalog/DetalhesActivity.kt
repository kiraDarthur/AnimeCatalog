package com.example.animecatalog

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val anime: Anime? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra("anime", Anime::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getSerializableExtra("anime") as? Anime
            }

        val imgAnime = findViewById<ImageView>(R.id.imgAnime)
        val txtNome = findViewById<TextView>(R.id.txtNome)
        val txtNota = findViewById<TextView>(R.id.txtNota)
        val txtPersonagem = findViewById<TextView>(R.id.txtPersonagem)
        val txtGenero = findViewById<TextView>(R.id.txtGenero)
        val txtEpisodios = findViewById<TextView>(R.id.txtEpisodios)
        val txtOpiniao = findViewById<TextView>(R.id.txtOpiniao)
        val txtData = findViewById<TextView>(R.id.txtData)

        anime?.let {

            imgAnime.setImageResource(it.imagem)

            txtNome.text = it.nome
            txtNota.text = "⭐ Nota: ${it.nota}"
            txtPersonagem.text = "❤️ Personagem favorita: ${it.personagem}"
            txtGenero.text = "🎭 Género: ${it.genero}"
            txtEpisodios.text = "📺 Episódios: ${it.episodios}"
            txtOpiniao.text = "📝 Opinião:\n${it.opiniao}"
            txtData.text = "📅 Data: ${it.data}"
        }
    }
}