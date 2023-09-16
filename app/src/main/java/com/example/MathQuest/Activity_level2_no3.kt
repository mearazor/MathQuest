package com.example.MathQuest

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.app.Dialog
import android.media.MediaPlayer

class Activitylevel2no3 : AppCompatActivity() {
    private lateinit var timerTextView: TextView
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var homeButton: Button
    private lateinit var pertanyaanButton: Button
    private lateinit var popup: Dialog
    private lateinit var soundEffectPlayer: MediaPlayer
    private lateinit var soundBenarPlayer: MediaPlayer
    private lateinit var soundSalahPlayer: MediaPlayer
    private lateinit var salahPopup: Dialog
    private lateinit var benarPopup: Dialog
    private lateinit var sharedPreferences: SharedPreferences // Deklarasi sharedPreferences
    private var timeLeft: Long = 120000
    private var nyawa = 3
    private var isPopupOpen = false
    private var isSalahPopupOpen = false
    private var isBenarPopupOpen = false
    private var pausedTimeLeft: Long = 0
    private var jumlahPopupSalah = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)
        soundBenarPlayer = MediaPlayer.create(this, R.raw.benar)
        soundSalahPlayer = MediaPlayer.create(this, R.raw.salah)

        setContentView(R.layout.activity_level2_no3)
        supportActionBar?.hide()
        homeButton = findViewById(R.id.bthome)
        timerTextView = findViewById(R.id.timer)
        pertanyaanButton = findViewById(R.id.btpertanyaan)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE) // Inisialisasi sharedPreferences

        val jawaban1: ImageView = findViewById(R.id.jawaban1l2)
        val jawaban2: ImageView = findViewById(R.id.jawaban2l2)
        val jawaban3: ImageView = findViewById(R.id.jawaban3l2)
        val gamelevel2: ImageView = findViewById(R.id.gamelevel2)

        // menambahkan OnClickListener ke gamabar "gamelevel1"
        gamelevel2.setOnClickListener {
            // memutar efek suara
            soundEffectPlayer.start()
            if (!isPopupOpen) {
                // Jika popup belum terbuka, simpan waktu sisa saat ini
                pausedTimeLeft = timeLeft
                countDownTimer.cancel() // Hentikan timer
                // Jika popup belum terbuka, periksa nyawa sebelum menampilkan popup_salah
                if (nyawa > 0) {
                    // Tambahkan kode untuk mengurangi nyawa
                    nyawa--
                    // Tambahkan jumlah munculnya popup_salah
                    jumlahPopupSalah++
                    // Tampilkan popup_salah
                    showSalahPopup()
                } else {
                    // Jika nyawa sudah habis, kembali ke halaman "activity_menu_level"
                    kembaliKeMenuLevel()
                }
            }
        }


        // Mengatur status level 2 sebagai "selesai" di Activitysoal1level2
        val editor = sharedPreferences.edit()
        editor.putBoolean("level2Completed", true)
        editor.apply()

        // Tambahkan OnClickListener ke gambar "jawaban1"
        jawaban1.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            if (!isPopupOpen) {
                // Jika popup belum terbuka, simpan waktu sisa saat ini
                pausedTimeLeft = timeLeft
                countDownTimer.cancel() // Hentikan timer
                // Jika popup belum terbuka, periksa nyawa sebelum menampilkan popup_salah
                if (nyawa > 0) {
                    // Tambahkan kode untuk mengurangi nyawa
                    nyawa--
                    // Tambahkan jumlah munculnya popup_salah
                    jumlahPopupSalah++
                    // Tampilkan popup_salah
                    showSalahPopup()
                } else {
                    // Jika nyawa sudah habis, kembali ke halaman "activity_menu_level"
                    kembaliKeMenuLevel()
                }
            }
        }

        // Tambahkan OnClickListener ke gambar "jawaban2"
        jawaban2.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            if (!isPopupOpen) {
                // Jika popup belum terbuka, simpan waktu sisa saat ini
                pausedTimeLeft = timeLeft
                countDownTimer.cancel() // Hentikan timer
                // Jika popup belum terbuka, periksa nyawa sebelum menampilkan popup_salah
                if (nyawa > 0) {
                    // Tambahkan kode untuk mengurangi nyawa
                    nyawa--
                    // Tambahkan jumlah munculnya popup_salah
                    jumlahPopupSalah++
                    // Tampilkan popup_salah
                    showSalahPopup()
                } else {
                    // Jika nyawa sudah habis, kembali ke halaman "activity_menu_level"
                    kembaliKeMenuLevel()
                }
            }
        }

        // Tambahkan OnClickListener ke gambar "jawaban3"
        jawaban3.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            if (!isPopupOpen) {
                // Jika popup belum terbuka, simpan waktu sisa saat ini
                pausedTimeLeft = timeLeft
                countDownTimer.cancel() // Hentikan timer
                showBenarPopup()
            }
        }

        startCountdownTimer()

        homeButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            val intent = Intent(this, Activitymenuutama::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

        pertanyaanButton.setOnClickListener {
            // Memutar efek suara
            soundEffectPlayer.start()
            if (!isPopupOpen) {
                // Jika popup belum terbuka, simpan waktu sisa saat ini
                pausedTimeLeft = timeLeft
                countDownTimer.cancel() // Hentikan timer
                showPopup()
            }
        }
    }

    private fun startCountdownTimer() {
        countDownTimer = object : CountDownTimer(timeLeft, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                if (!isPopupOpen && !isBenarPopupOpen && !isSalahPopupOpen) {
                    timeLeft = millisUntilFinished
                    updateTimer()
                }
            }

            override fun onFinish() {
                // Timer selesai, Anda bisa menangani ini di sini
            }
        }.start()
    }

    private fun updateTimer() {
        val minutes = (timeLeft / 1000) / 60
        val seconds = (timeLeft / 1000) % 60
        val timeLeftString = String.format("%02d:%02d", minutes, seconds)
        timerTextView.text = timeLeftString
    }

    private fun showPopup() {
        isPopupOpen = true
        popup = Dialog(this, R.style.TransparentDialog)
        popup.setContentView(R.layout.popup_level2_no3)
        popup.setCancelable(false)

        val btnYes: Button = popup.findViewById(R.id.btnYes)
        val btnNo: Button = popup.findViewById(R.id.btnNo)

        btnYes.setOnClickListener {
            closePopup()
        }
        btnNo.setOnClickListener {
            // Tambahkan kode untuk kembali ke halaman "activity_menu_level"
            val intent = Intent(this, Activitymenulevel::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish() // Optional: Menutup Activity saat kembali ke "activity_menu_level"
        }

        popup.show()
    }

    private fun closePopup() {
        isPopupOpen = false
        popup.dismiss()

        // Setel waktu sisa kembali ke waktu saat popup terbuka
        timeLeft = pausedTimeLeft

        // Mulai ulang timer jika popup ditutup
        startCountdownTimer()
    }

    private fun showBenarPopup() {
        isBenarPopupOpen = true
        benarPopup = Dialog(this, R.style.TransparentDialog)
        benarPopup.setContentView(R.layout.popup_benar)
        benarPopup.setCancelable(false)

        val btnYes: Button = benarPopup.findViewById(R.id.btnYes)
        val btnNo: Button = benarPopup.findViewById(R.id.btnNo)

        // Memutar efek suara "benar"
        soundBenarPlayer.start()

        btnYes.setOnClickListener {
            benarPopup.dismiss()
            val intent = Intent(this, Activitysoal1level3::class.java)
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        btnNo.setOnClickListener {
            benarPopup.dismiss()
            // Tambahkan kode lain yang diperlukan saat tombol "No" ditekan
        }

        benarPopup.show()
    }

    private fun showSalahPopup() {
        isSalahPopupOpen = true
        salahPopup = Dialog(this, R.style.TransparentDialog)
        salahPopup.setContentView(R.layout.popup_salah)
        salahPopup.setCancelable(false)

        val btnYes: Button = salahPopup.findViewById(R.id.btnYes)
        val btnNo: Button = salahPopup.findViewById(R.id.btnNo)

        // Memutar efek suara "salah"
        soundSalahPlayer.start()

        btnYes.setOnClickListener {
            salahPopup.dismiss()
            isSalahPopupOpen = false
            if (!isPopupOpen && !isBenarPopupOpen) {
                startCountdownTimer()
            }
        }
        btnNo.setOnClickListener {
            salahPopup.dismiss()
            isSalahPopupOpen = false
            if (!isPopupOpen && !isBenarPopupOpen) {
                startCountdownTimer()
            }
        }

        salahPopup.show()
    }

    private fun kembaliKeMenuLevel() {
        val intent = Intent(this, Activitymenulevel::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)
        // Memberikan efek transisi fade
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}
