package com.project.banksampah.view.splash

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.project.banksampah.R
import com.project.banksampah.databinding.ActivitySplashBinding
import com.project.banksampah.view.main.MainActivity
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {
    companion object {
        const val RC_LOCATION = 1
    }

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        requestLocationPermission()

    }

    @AfterPermissionGranted(RC_LOCATION)
    private fun requestLocationPermission() {
        val perms = arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION)
        if (EasyPermissions.hasPermissions(this, *perms)) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            EasyPermissions.requestPermissions(
                this,
                getString(R.string.location_racionale),
                RC_LOCATION,
                *perms
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        when (requestCode) {
            RC_LOCATION -> startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        when (requestCode) {
            RC_LOCATION -> {
                Toast.makeText(
                    this,
                    "Aplikasi tidak bisa mengakses lokasi, anda bisa mengaktifkannya melalui pengaturan",
                    Toast.LENGTH_SHORT
                ).show()
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}
