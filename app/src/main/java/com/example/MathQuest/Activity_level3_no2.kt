package com.example.MathQuest

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Activitylevel3no2 : AppCompatActivity() {
    private lateinit var timerTextView: TextView
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var homeButton: Button
    private lateinit var pertanyaanButton: Button
    private lateinit var popup: Dialog
    private lateinit var soundEffectPlayer: MediaPlayer
    private lateinit var soundBenarPlayer: MediaPlayer
    private lateinit var soundSalahPlayer: MediaPlayer
    private lateinit var salahPopup: Dialog // Tambahkan Dialog untuk popup salah
    private lateinit var benarPopup: Dialog // Tambahkan Dialog untuk popup benar
    private var timeLeft: Long = 120000
    private var nyawa = 3
    private var isPopupOpen = false
    private var isSalahPopupOpen = false
    private var isBenarPopupOpen = false
    private var pausedTimeLeft: Long = 0 // Menyimpan waktu sisa saat popup terbuka
    private var jumlahPopupSalah = 0 // Menyimpan jumlah munculnya popup_salah

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        soundEffectPlayer = MediaPlayer.create(this, R.raw.bteffect)
        soundBenarPlayer = MediaPlayer.create(this, R.raw.benar)
        soundSalahPlayer = MediaPlayer.create(this, R.raw.salah)

        setContentView(R.layout.activity_level3_no2)
        supportActionBar?.hide()
        homeButton = findViewById(R.id.bthome)
        timerTextView = findViewById(R.id.timer)
        pertanyaanButton = findViewById(R.id.btpertanyaan)

        val jawaban1: ImageView = findViewById(R.id.jawaban1l3)
        val jawaban2: ImageView = findViewById(R.id.jawaban2l3)
        val jawaban3: ImageView = findViewById(R.id.jawaban3l3)
        val jawaban4: ImageView = findViewById(R.id.jawaban4l3)
        val gamelevel3: ImageView = findViewById(R.id.gamelevel3)

        // menambahkan OnClickListener ke gamabar "gamelevel1"
        gamelevel3.setOnClickListener {
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
                showBenarPopup()
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
        // Tambahkan OnClickListener ke gambar "jawaban4"
        jawaban4.setOnClickListener {
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
        popup.setContentView(R.layout.popup_level3_no2)
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
            // Tutup popup benar
            benarPopup.dismiss()
            // Buka activity_soal2_level1
            val intent = Intent(this, Activitysoal3level3::class.java)
            startActivity(intent)
            // Memberikan efek transisi fade
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish() // Optional: Menutup Activity saat pindah ke activity_soal2_level2
        }
        btnNo.setOnClickListener {
            benarPopup.dismiss() // Menutup popup benar
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
            // Tambahkan kode lain yang diperlukan saat tombol "Yes" ditekan
            salahPopup.dismiss()
            // Mulai ulang timer jika popup ditutup dan tidak ada popup lain yang terbuka
            isSalahPopupOpen = false
            if (!isPopupOpen && !isBenarPopupOpen) {
                startCountdownTimer()
            }
        }
        btnNo.setOnClickListener {
            // Tambahkan kode lain yang diperlukan saat tombol "No" ditekan
            salahPopup.dismiss()
            // Mulai ulang timer jika popup ditutup dan tidak ada popup lain yang terbuka
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
