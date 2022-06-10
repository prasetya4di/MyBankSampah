package com.project.banksampah.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.banksampah.databinding.ActivityMainBinding
import com.project.banksampah.databinding.ContentMainBinding
import com.project.banksampah.view.history.HistoryActivity
import com.project.banksampah.view.jenissampah.SampahTypeActivity
import com.project.banksampah.view.pickup.PickUpActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contentMainBinding: ContentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        contentMainBinding = ContentMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        contentMainBinding.cvPickup.setOnClickListener {
            startActivity(Intent(this, PickUpActivity::class.java))
        }
        contentMainBinding.cvHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }
        contentMainBinding.cvKategori.setOnClickListener {
            startActivity(Intent(this, SampahTypeActivity::class.java))
        }
    }
}
