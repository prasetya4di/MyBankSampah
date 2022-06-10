package com.project.banksampah.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.banksampah.databinding.ActivityMainBinding
import com.project.banksampah.view.history.HistoryActivity
import com.project.banksampah.view.jenissampah.SampahTypeActivity
import com.project.banksampah.view.pickup.PickUpActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.content.cvPickup.setOnClickListener {
            startActivity(Intent(this, PickUpActivity::class.java))
        }
        binding.content.cvHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
        binding.content.cvKategori.setOnClickListener {
            startActivity(Intent(this, SampahTypeActivity::class.java))
        }
    }
}
