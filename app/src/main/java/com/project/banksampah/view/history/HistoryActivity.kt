package com.project.banksampah.view.history

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.banksampah.databinding.ActivityHistoryBinding
import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.util.Formatter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val viewModel: HistoryViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val layoutManager = LinearLayoutManager(this)
        binding.rvHistory.layoutManager = layoutManager
        viewModel.totalBalance.observeForever {
            if (it != null) {
                binding.tvReceive.text = Formatter.rupiahFormat(it)
            }
        }
        viewModel.pickUps.observeForever {
            val adapter = HistoryAdapter(it, object : HistoryAdapter.HistoryAdapterCallback {
                override fun onDelete(pickup: PickUp) {
                    viewModel.deletePickUp(pickup)
                }
            })
            binding.rvHistory.adapter = adapter
        }
    }
}
