package com.example.animecatalog

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaAdapter(
    private val lista: List<Anime>
) : RecyclerView.Adapter<ListaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgAnime: ImageView = itemView.findViewById(R.id.imgAnime)
        val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        val txtNota: TextView = itemView.findViewById(R.id.txtNota)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val anime = lista[position]

        holder.imgAnime.setImageResource(anime.imagem)
        holder.txtNome.text = anime.nome
        holder.txtNota.text = "⭐ ${anime.nota}/10"

        holder.itemView.setOnClickListener {

            val intent = Intent(
                holder.itemView.context,
                DetalhesActivity::class.java
            )

            intent.putExtra("anime", anime)

            holder.itemView.context.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {

        return lista.size

    }

}