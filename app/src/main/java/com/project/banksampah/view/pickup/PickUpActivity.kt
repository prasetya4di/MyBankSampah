package com.project.banksampah.view.pickup

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.banksampah.databinding.ActivityPickUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PickUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPickUpBinding
    private val viewModel: PickUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCheckout.setOnClickListener {

        }
    }
}
