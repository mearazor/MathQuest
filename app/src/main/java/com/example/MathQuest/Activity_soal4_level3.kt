package com.example.MathQuest

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button

class Activitysoal4level3 : AppCompatActivity() {

    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_soal4_level3)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        homeButton = findViewById(R.id.bthome) // Inisialisasi tombol home

        // Inisialisasi tombol "mulaigame"
        val mulaiGameButton = findViewById<Button>(R.id.mulaigame)

        // Menambahkan OnClickListener pada tombol "mulaigame"
        mulaiGameButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Skor awal (misalnya, 10)
            val skorAwal = 10
            // Buka activity_level1_no3 dan kirim skor yang telah ditingkatkan (20)
            val intent = Intent(this, Activitylevel3no4::class.java)
            intent.putExtra("score", skorAwal + 10) // Mengirim skor yang ditingkatkan
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()

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
