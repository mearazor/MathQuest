package com.example.MathQuest

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activitymenulevel : AppCompatActivity() {

    private lateinit var homeButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_menu_level)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        homeButton = findViewById(R.id.bthome) // Inisialisasi tombol home
        val level1Button = findViewById<Button>(R.id.btlevel1)
        val level2Button = findViewById<Button>(R.id.btlevel2) // Inisialisasi tombol level 2
        val level3Button = findViewById<Button>(R.id.btlevel3) // Inisialisasi tombol level 3

        // Mengecek apakah level 1 sudah selesai
        level1Button.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Membuat intent untuk membuka Activity_soal1_level1
            val intent = Intent(this, Activitysoal1level1::class.java)
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

        // Tambahkan OnClickListener untuk tombol level 2
        level2Button.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Membuat intent untuk membuka Activity_soal1_level2
            val intent = Intent(this, Activitysoal1level2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // Tambahkan OnClickListener untuk tombol level 3
        level3Button.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Membuat intent untuk membuka Activity_soal1_level3
            val intent = Intent(this, Activitysoal1level3::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}
