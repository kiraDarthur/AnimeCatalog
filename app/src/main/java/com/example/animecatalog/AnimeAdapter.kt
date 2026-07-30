package com.example.animecatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimeAdapter(
    private val lista: List<Anime>,
    private val onClick: (Anime) -> Unit
) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAnime: ImageView = itemView.findViewById(R.id.imgAnime)
        val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        val txtNota: TextView = itemView.findViewById(R.id.txtNota) // Campo de Nota adicionado
        val txtClique: TextView = itemView.findViewById(R.id.txtClique)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_anime, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = lista[position]

        holder.imgAnime.setImageResource(anime.imagem)
        holder.txtNome.text = anime.nome
        holder.txtClique.text = "👆 Clique para avaliar"

        // 🌟 Exibe a nota formatada
        if (anime.nota > 0.0) {
            holder.txtNota.text = "⭐ Nota: ${anime.nota}"
        } else {
            holder.txtNota.text = "⭐ Sem avaliação"
        }

        holder.itemView.setOnClickListener {
            onClick(anime)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}