package com.project.banksampah.view.jenissampah

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.banksampah.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SampahTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sampah_type)
    }
}
