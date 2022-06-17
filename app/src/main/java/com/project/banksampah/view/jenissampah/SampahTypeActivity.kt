package com.project.banksampah.view.jenissampah

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.banksampah.databinding.ActivitySampahTypeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampahTypeActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySampahTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampahTypeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbar.setOnClickListener { onBackPressed() }
    }
}
