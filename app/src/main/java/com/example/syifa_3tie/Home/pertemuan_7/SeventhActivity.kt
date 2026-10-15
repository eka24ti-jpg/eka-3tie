package com.example.syifa_3tie.Home.pertemuan_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.syifa_3tie.R
import com.example.syifa_3tie.databinding.ActivitySevenBinding

class SeventhActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar & Tombol Back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Pertemuan 7"
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        // 1. Menampilkan SatuFragment secara default saat Activity pertama dibuka
        replaceFragment(SatuFragment())

        // 2. Setup event click untuk mengganti fragment saat tombol ditekan
        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    // Fungsi untuk mengganti fragment di dalam fragmentContainer
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}