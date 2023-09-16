package com.example.MathQuest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.widget.Button
import android.widget.ImageView
import android.view.View

class Activitymenukurikulum : AppCompatActivity() {

    private lateinit var popup: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)

        setContentView(R.layout.activity_menu_kurikulum)

        // Menghilangkan ActionBar
        supportActionBar?.hide()

        popup = Dialog(this)
        popup.setContentView(R.layout.popup_kurikulum)
        val popupImageView = popup.findViewById<ImageView>(R.id.popupImageView)

        val blurBackground = popup.findViewById<View>(R.id.blurBackground)
        blurBackground.alpha = 1.0f // Set alpha ke 1 untuk menghilangkan efek transparansi
        blurBackground.setOnClickListener {
            popup.dismiss()
        }

        popupImageView.setImageResource(R.drawable.textki) // Ganti gambar_baru dengan sumber daya yang sesuai

        val btkiButton = findViewById<Button>(R.id.btki)
        btkiButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            popup.window?.setBackgroundDrawableResource(android.R.color.transparent)
            popup.setCanceledOnTouchOutside(true)
            popup.show()
        }

        val btkdButton = findViewById<Button>(R.id.btkd)
        btkdButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            popup.window?.setBackgroundDrawableResource(android.R.color.transparent)
            popup.setCanceledOnTouchOutside(true)
            popupImageView.setImageResource(R.drawable.textkd)
            popup.show()
        }

        val bthomeButton = findViewById<Button>(R.id.bthome)
        bthomeButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            val intent = Intent(this, Activitymenuutama::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
