package com.example.MathQuest

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activitymenumateri : AppCompatActivity() {

    private lateinit var homeButton: Button
    private lateinit var ceritaButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_menu_materi)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        homeButton = findViewById(R.id.bthome) // Inisialisasi tombol home
        ceritaButton = findViewById(R.id.btsoalcerita)

        val btsubmateri1 = findViewById<Button>(R.id.btsubmateri1)
        btsubmateri1.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Membuat intent untuk membuka Activity_submateri1
            val intent = Intent(this, Activitysub1::class.java)
            // Mengatur flag untuk menghindari penumpukan halaman
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        val btsubmateri2 = findViewById<Button>(R.id.btsubmateri2)
        btsubmateri2.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Membuat intent untuk membuka Activity_submateri2
            val intent = Intent(this, Activityeli1::class.java)
            // Mengatur flag untuk menghindari penumpukan halaman
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        val btsubmateri3 = findViewById<Button>(R.id.btsubmateri3)
        btsubmateri3.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Membuat intent untuk membuka Activity_submateri3
            val intent = Intent(this, Activitygab1::class.java)
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
        ceritaButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Buat Intent untuk kembali ke Activitymenuutama
            val intent = Intent(this, Activitycerita1::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
