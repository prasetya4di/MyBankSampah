package com.project.banksampah.view.pickup

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.DatePicker
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.project.banksampah.R
import com.project.banksampah.databinding.ActivityPickUpBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class PickUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPickUpBinding
    private val viewModel: PickUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.inputName.doOnTextChanged { text, _, _, _ -> viewModel.setName(text.toString()) }
        binding.inputAddress.doOnTextChanged { text, _, _, _ -> viewModel.setAddress(text.toString()) }
        binding.inputNote.doOnTextChanged { text, _, _, _ -> viewModel.setNote(text.toString()) }
        binding.inputWeight.doOnTextChanged { text, _, _, _ ->
            viewModel.changeKg(Integer.parseInt(text.toString()))
        }
        binding.spKategori.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val category = parent?.getItemAtPosition(position).toString()
                val strPrice = resources.getStringArray(R.array.price_per_kg)[position]
                viewModel.setSelectedCategory(category, Integer.parseInt(strPrice))
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        binding.inputDate.setOnClickListener {
            val pickupDate = Calendar.getInstance()
            val date =
                DatePickerDialog.OnDateSetListener { _: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                    pickupDate[Calendar.YEAR] = year
                    pickupDate[Calendar.MONTH] = monthOfYear
                    pickupDate[Calendar.DAY_OF_MONTH] = dayOfMonth
                    val strFormatDefault = "d MMMM yyyy"
                    val simpleDateFormat = SimpleDateFormat(strFormatDefault, Locale.getDefault())
                    viewModel.setPickUpDate(pickupDate.time)
                    binding.inputDate.setText(simpleDateFormat.format(pickupDate.time))
                }
            DatePickerDialog(
                this, date,
                pickupDate[Calendar.YEAR],
                pickupDate[Calendar.MONTH],
                pickupDate[Calendar.DAY_OF_MONTH]
            ).show()
        }
        binding.btnCheckout.setOnClickListener {
            viewModel.addPickUp()
        }
    }
}
