package com.project.banksampah.view.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.project.banksampah.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
    }
}
