package com.example.animecatalog

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Liga esta Activity ao layout
        setContentView(R.layout.activity_splash)

        // Procura o ImageView onde será mostrado o GIF
        val imgGif = findViewById<ImageView>(R.id.imgGif)

        // Carrega o GIF utilizando Glide
        Glide.with(this)
            .asGif()
            .load(R.drawable.abertura2)
            .into(imgGif)

        // Espera 10 segundos
        Handler(Looper.getMainLooper()).postDelayed({

            // Abre a próxima tela
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Fecha a Splash para não voltar quando carregar em "Voltar"
            finish()

        }, 10000)
    }
}