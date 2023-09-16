package com.example.MathQuest

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button

class Activitysoal2level2 : AppCompatActivity() {

    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_soal2_level2)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        homeButton = findViewById(R.id.bthome) // Inisialisasi tombol home

        // Inisialisasi tombol "mulaigame"
        val mulaiGameButton = findViewById<Button>(R.id.mulaigame)

        // Menambahkan OnClickListener pada tombol "mulaigame"
        mulaiGameButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Ambil skor dari intent
            val skor = intent.getIntExtra("score", 0)
            // Buka activity_level1_no2 dan kirim skor
            val intent = Intent(this, Activitylevel2no2::class.java)
            intent.putExtra("score", skor)
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish() // Optional: Menutup Activity saat pindah ke activity_level1_no2
        }
        // Menambahkan OnClickListener untuk tombol home
        homeButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Buat Intent untuk kembali ke Activitymenuutama
            val intent = Intent(this, Activitymenuutama::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
