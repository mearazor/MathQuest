package com.example.MathQuest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.os.Looper

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_splash_screen)

        // Buat handler untuk menunda pembukaan frame halaman utama selama 3 detik
        Handler(Looper.getMainLooper()).postDelayed({
            // Intent untuk membuka frame halaman utama
            val intent = Intent(this, Activitylogin::class.java)
            startActivity(intent)

            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            finish() // Tutup activity ini agar tidak dapat dikembalikan dengan tombol back
        }, 3000) // Delay 3 detik (3000 milidetik)
    }
}
