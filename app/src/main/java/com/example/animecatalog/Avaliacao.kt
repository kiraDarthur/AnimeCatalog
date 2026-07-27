package com.example.animecatalog

import java.io.Serializable

data class Avaliacao(

    val anime: Anime,

    val nota: Double,

    val personagem: String,

    val genero: String,

    val episodios: String,

    val opiniao: String,

    val data: String

) : Serializable