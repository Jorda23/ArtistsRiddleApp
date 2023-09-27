package com.example.game_guess

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class secondScreen : AppCompatActivity() {

    private var attemptsRemaining = 5
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)


        val imagesArtist = mapOf(
            R.drawable.taylor to "Taylor",
            R.drawable.eminem to "Eminem",
            R.drawable.justin to "Justin",
            R.drawable.onerepublic to "OneRepublic"
        )

        val characterImageView: ImageView = findViewById(R.id.personajeImageView)
        val nombrePersonajeEditText: EditText = findViewById(R.id.nombrePersonajeEditText)
        val verifyButton: Button = findViewById(R.id.verificarButton)

        val (idImagenAleatoria, nombrePersonaje) = imagesArtist.entries.random()
        characterImageView.setImageResource(idImagenAleatoria)

        verifyButton.setOnClickListener {
            val respuestaUsuario = nombrePersonajeEditText.text.toString().trim()
            nombrePersonajeEditText.text.clear()

            if (respuestaUsuario.equals(nombrePersonaje, ignoreCase = true)) {
                val intent = Intent(this, SuccessActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                attemptsRemaining--
                if (attemptsRemaining <= 0) {
                    val intent = Intent(this, ErrorMessageActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Incorrect! Remaining intentions: $attemptsRemaining", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer = MediaPlayer.create(this, R.raw.angels)
        mediaPlayer.start()
    }

    override fun onPause() {
        super.onPause()

        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()
    }
}
