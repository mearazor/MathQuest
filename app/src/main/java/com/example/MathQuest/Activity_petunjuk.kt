package com.example.MathQuest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.widget.Button
import android.content.Intent

class Activitypetunjuk : AppCompatActivity() {

    private lateinit var homeButton: Button // Tambahkan tombol home
    private lateinit var effectMediaPlayer: MediaPlayer // Tambahkan MediaPlayer untuk efek suara

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_petunjuk)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        homeButton = findViewById(R.id.bthome) // Inisialisasi tombol home

        // Inisialisasi MediaPlayer untuk efek suara
        effectMediaPlayer = MediaPlayer.create(this, R.raw.bteffect)

        // Menambahkan OnClickListener untuk tombol home
        homeButton.setOnClickListener {
            navigateToMenuUtama()
        }
    }

    private fun navigateToMenuUtama() {
        // Memainkan suara efek saat tombol home ditekan
        effectMediaPlayer.start()
        // Buat Intent untuk kembali ke Activitymenuutama
        val intent = Intent(this, Activitymenuutama::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        // Memberikan efek transisi fade
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        effectMediaPlayer.release() // Melepaskan sumber daya MediaPlayer efek suara
    }
}
