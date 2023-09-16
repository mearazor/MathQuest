package com.example.MathQuest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.media.MediaPlayer

class Activitylogin : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer // Deklarasikan variabel MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        val secondAtcbutton = findViewById<Button>(R.id.btmasuk)
        secondAtcbutton.setOnClickListener {
            // Memainkan suara sebelum membuka aktivitas
            mediaPlayer = MediaPlayer.create(this, R.raw.bteffect)
            mediaPlayer.start()

            // Membuka aktivitas setelah memainkan suara
            val intent = Intent(this, Activitymenuutama::class.java)
            startActivity(intent)

            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            // Hapus efek transisi
            overridePendingTransition(0, 0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release() // Pastikan untuk melepaskan sumber daya MediaPlayer saat tidak diperlukan lagi
    }
}