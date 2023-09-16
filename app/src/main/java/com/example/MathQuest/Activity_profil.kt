package com.example.MathQuest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.widget.Button
import android.content.Intent

class Activityprofil : AppCompatActivity() {

    private lateinit var homeButton: Button
    private lateinit var effectMediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        homeButton = findViewById(R.id.bthome)

        // Inisialisasi effectMediaPlayer
        effectMediaPlayer = MediaPlayer.create(this, R.raw.bteffect) // Gantilah dengan sumber audio yang sesuai

        homeButton.setOnClickListener {
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
    }

    override fun onDestroy() {
        super.onDestroy()

        // Pastikan untuk melepaskan MediaPlayer efek suara jika sudah diinisialisasi
        if (this::effectMediaPlayer.isInitialized) {
            effectMediaPlayer.release()
        }
    }
}
