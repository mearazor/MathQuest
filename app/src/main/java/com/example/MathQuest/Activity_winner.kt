package com.example.MathQuest

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Activitywinner : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_winner)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        val backButton = findViewById<Button>(R.id.btreset) // Inisialisasi tombol kembali

        // Tambahkan OnClickListener untuk tombol kembali di ActivityWinner
        backButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Kembali ke ActivityMenuLevel
            val intent = Intent(this, Activitymenulevel::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}
