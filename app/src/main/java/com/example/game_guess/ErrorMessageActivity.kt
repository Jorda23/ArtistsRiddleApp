package com.example.game_guess

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ErrorMessageActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error_message)

        val regresarSecondScreenButton: Button = findViewById(R.id.regresarFirstScreenButton)

        mediaPlayer = MediaPlayer.create(this, R.raw.error)
        mediaPlayer.start()

        regresarSecondScreenButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {

        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()
        super.onDestroy()
    }
}
