package com.example.syifa_3tie.Home.pertemuan_6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.syifa_3tie.BaseActivity // 1. Import BaseActivity
import com.example.syifa_3tie.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menghubungkan View Binding
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inisialisasi SharedPreferences
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        // Aksi ketika tombol Login diklik
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Sesuai syarat modul: Jika Username = Password
            if (username.isNotEmpty() && username == password) {
                // Simpan session status login dan username ke SharedPreferences
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()

                // 2. Berpindah ke BaseActivity (menggantikan MainActivity)
                val intent = Intent(this, BaseActivity::class.java)
                startActivity(intent)
                finish() // Menutup AuthActivity
            } else {
                // Jika tidak sama, tampilkan AlertDialog
                AlertDialog.Builder(this)
                    .setTitle("Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}