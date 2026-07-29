package com.example.animecatalog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaActivity : AppCompatActivity() {

    private lateinit var recyclerLista: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista)

        recyclerLista = findViewById(R.id.recyclerLista)

        recyclerLista.layoutManager = LinearLayoutManager(this)

        recyclerLista.adapter = ListaAdapter(AvaliacoesData.listaAvaliacoes)
    }
}