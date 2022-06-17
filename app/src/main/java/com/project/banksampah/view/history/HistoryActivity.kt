package com.project.banksampah.view.history

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
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

        binding.toolbar.setOnClickListener { onBackPressed() }
        val layoutManager = LinearLayoutManager(this)
        binding.rvHistory.layoutManager = layoutManager
        viewModel.totalBalance.observeForever {
            binding.tvReceive.text = Formatter.rupiahFormat(it ?: 0)
        }
        viewModel.pickUps.observeForever {
            val adapter = HistoryAdapter(it, object : HistoryAdapter.HistoryAdapterCallback {
                override fun onDelete(pickup: PickUp) {
                    AlertDialog.Builder(this@HistoryActivity)
                        .setTitle("Konfirmasi Hapus")
                        .setMessage("Apakah anda yakin akan menghapus ${pickup.uid} - ${pickup.name}")
                        .setPositiveButton("YES") { _, _ -> viewModel.deletePickUp(pickup) }
                        .setNegativeButton("NO") { _, _ -> }
                        .show()
                }
            })
            binding.rvHistory.adapter = adapter
        }
    }
}
