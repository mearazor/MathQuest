package com.example.MathQuest

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Activityevaluasi : AppCompatActivity() {

    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_evaluasi)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        homeButton = findViewById(R.id.bthome) // Inisialisasi tombol home

        val secondAtcbutton = findViewById<Button>(R.id.btmulai)
        secondAtcbutton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Membuka aktivitas setelah memainkan suara
            val intent = Intent(this, Activitymenulevel::class.java)
            // Mengatur flag untuk menghindari penumpukan halaman
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
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