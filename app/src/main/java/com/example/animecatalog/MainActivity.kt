package com.example.animecatalog

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerAnimes: RecyclerView
    private lateinit var adapter: AnimeAdapter

    private val launcherReview = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val nomeAnime = result.data?.getStringExtra("EXTRA_NOME_ANIME")
            val notaTexto = result.data?.getStringExtra("EXTRA_NOTA")

            if (nomeAnime != null && notaTexto != null) {
                val notaDouble = notaTexto.toDoubleOrNull() ?: 0.0

                // 1. Procura o anime e atualiza a nota
                for (anime in AnimeData.listaAnimes) {
                    if (anime.nome == nomeAnime) {
                        anime.nota = notaDouble
                        break
                    }
                }

                // 2. Reordena do maior para o menor
                AnimeData.listaAnimes.sortByDescending { it.nota }

                // 3. Notifica a lista para atualizar a tela
                adapter.notifyDataSetChanged()

                Toast.makeText(
                    this,
                    "Ranking atualizado! $nomeAnime ficou com nota $notaDouble",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerAnimes = findViewById(R.id.recyclerAnimes)
        recyclerAnimes.layoutManager = LinearLayoutManager(this)

        adapter = AnimeAdapter(AnimeData.listaAnimes) { anime ->
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("anime", anime)
            launcherReview.launch(intent)
        }

        recyclerAnimes.adapter = adapter
    }
}