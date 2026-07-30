package com.example.animecatalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        recyclerView = findViewById(R.id.recyclerLista)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val listaOrdenada =
            AvaliacoesData.listaAvaliacoes.sortedByDescending { it.nota }

        adapter = ListaAdapter(listaOrdenada)

        recyclerView.adapter = adapter
    }
}