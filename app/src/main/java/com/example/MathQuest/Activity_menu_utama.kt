package com.example.MathQuest

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences

class Activitymenuutama : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var muteButton: Button
    private lateinit var petunjukButton: Button
    private lateinit var btkikdButton: Button
    private lateinit var btmateridButton: Button // Tambahkan tombol btmateri
    private lateinit var btprofilButton: Button
    private lateinit var btevaluasiButton: Button
    private var isMuted = false
    private lateinit var sharedPreferences: SharedPreferences

    // Deklarasi MediaPlayer untuk efek suara
    private lateinit var effectMediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_menu_utama)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        mediaPlayer = MediaPlayer.create(this, R.raw.backsound)
        muteButton = findViewById(R.id.btsound)
        petunjukButton = findViewById(R.id.btpetunjuk)
        btkikdButton = findViewById(R.id.btkikd)
        btmateridButton = findViewById(R.id.btmateri) // Inisialisasi tombol btmateri
        btprofilButton = findViewById(R.id.btprofil)
        btevaluasiButton = findViewById(R.id.btevaluasi)

        // Inisialisasi MediaPlayer untuk efek suara
        effectMediaPlayer = MediaPlayer.create(this, R.raw.bteffect)

        // Mulai pemutaran suara secara otomatis saat frame terbuka
        mediaPlayer.start()

        muteButton.setOnClickListener {
            toggleMute()
        }

        // Menambahkan OnClickListener untuk tombol petunjuk
        petunjukButton.setOnClickListener {
            // Memainkan suara efek saat tombol petunjuk ditekan
            effectMediaPlayer.start()

            // Buat Intent untuk membuka Activitypetunjuk
            val intent = Intent(this, Activitypetunjuk::class.java)
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // Menambahkan OnClickListener untuk tombol btkikd
        btkikdButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            val intent = Intent(this, Activitymenukurikulum::class.java)
            // Mengatur flag untuk menghindari penumpukan halaman
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        // Menambahkan OnClickListener untuk tombol btmateri
        btmateridButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            val intent = Intent(this, Activitymenumateri::class.java)
            // Mengatur flag untuk menghindari penumpukan halaman
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        // Menambahkan OnClickListener untuk tombol petunjuk
        btprofilButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Buat Intent untuk membuka Activityprofil
            val intent = Intent(this, Activityprofil::class.java)
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
        // Menambahkan OnClickListener untuk tombol petunjuk
        btevaluasiButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Buat Intent untuk membuka Activityevaluasi
            val intent = Intent(this, Activityevaluasi::class.java)
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }

    private fun toggleMute() {
        if (isMuted) {
            mediaPlayer.start()
            muteButton.setBackgroundResource(R.drawable.sound)
        } else {
            mediaPlayer.pause()
            muteButton.setBackgroundResource(R.drawable.sound_off)
        }
        isMuted = !isMuted
    }

    override fun onDestroy() {
        super.onDestroy()

        mediaPlayer.release()
        effectMediaPlayer.release() // Melepaskan sumber daya MediaPlayer efek suara
    }
}
