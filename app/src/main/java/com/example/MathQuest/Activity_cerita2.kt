package com.example.MathQuest

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activitycerita2 : AppCompatActivity() {

    private lateinit var backbutton: Button
    private lateinit var nextbutton: Button
    private lateinit var homebutton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_cerita2)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        backbutton = findViewById(R.id.btback)
        nextbutton = findViewById(R.id.btnext)
        homebutton = findViewById(R.id.bthome)

        backbutton.setOnClickListener {
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
        nextbutton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            // Buat Intent untuk kembali ke Activitymenuutama
            val intent = Intent(this, Activitymenumateri::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        homebutton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            val intent = Intent(this, Activitymenuutama::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}