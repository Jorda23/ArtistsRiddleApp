package com.example.game_guess

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class successScreenActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_screen)

        val returnVerifyScreen: Button = findViewById(R.id.regresarFirstScreenButton)
        val returnMainScreen: Button = findViewById(R.id.regresarFirstScreenButton)

        mediaPlayer = MediaPlayer.create(this, R.raw.success)

        mediaPlayer.start()

        returnVerifyScreen.setOnClickListener {
            val intent = Intent(this, verifyScreen::class.java)
            startActivity(intent)
        }

        returnMainScreen.setOnClickListener {
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
