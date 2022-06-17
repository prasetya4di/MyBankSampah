package com.project.banksampah.view.main

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.project.banksampah.databinding.ActivityMainBinding
import com.project.banksampah.view.history.HistoryActivity
import com.project.banksampah.view.jenissampah.SampahTypeActivity
import com.project.banksampah.view.pickup.PickUpActivity
import dagger.hilt.android.AndroidEntryPoint
import im.delight.android.location.SimpleLocation
import pub.devrel.easypermissions.EasyPermissions
import java.io.IOException
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var simpleLocation: SimpleLocation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (EasyPermissions.hasPermissions(this, ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION)) {
            setLocation()
        } else {
            binding.layoutLocation.visibility = View.GONE
        }
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

    private fun setLocation() {
        simpleLocation = SimpleLocation(this)
        if (!simpleLocation.hasLocationEnabled()) {
            SimpleLocation.openSettings(this)
        }
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addressList =
                geocoder.getFromLocation(simpleLocation.latitude, simpleLocation.longitude, 1)
            if (addressList != null && addressList.size > 0) {
                val strCurrentLocation = addressList[0].locality
                binding.tvCurrentLocation.text = strCurrentLocation
                binding.tvCurrentLocation.isSelected = true
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
