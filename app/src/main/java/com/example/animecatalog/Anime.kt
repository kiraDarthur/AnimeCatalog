package com.example.animecatalog

import java.io.Serializable

data class Anime(
    val nome: String,
    val imagem: Int,

    var nota: Double = 0.0,
    var personagem: String = "",
    var genero: String = "",
    var episodios: Int = 0,
    var opiniao: String = "",
    var data: String = ""

) : Serializable