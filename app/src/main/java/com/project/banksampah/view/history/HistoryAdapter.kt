package com.project.banksampah.view.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.banksampah.databinding.ItemHistoryBinding
import com.project.banksampah.model.entity.PickUp

class HistoryAdapter(
    private val pickups: List<PickUp>,
    private val historyAdapterCallback: HistoryAdapterCallback
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    interface HistoryAdapterCallback {
        fun onDelete(pickup: PickUp)
    }

    inner class ViewHolder(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.ViewHolder =
        ViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: HistoryAdapter.ViewHolder, position: Int) {
        val pickup = pickups[position]
        holder.binding.imageDelete.setOnClickListener { historyAdapterCallback.onDelete(pickup) }
        holder.binding.tvName.text = pickup.name
        holder.binding.tvDate.text = pickup.tanggal
        holder.binding.tvCategory.text = pickup.type
        holder.binding.tvWeight.text = "${pickup.berat} Kg"
        holder.binding.tvReceive.text = pickup.harga.toString()
        holder.binding.tvStatus.text = "Received"
    }

    override fun getItemCount(): Int = pickups.size
}
