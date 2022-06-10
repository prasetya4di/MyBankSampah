package com.project.banksampah.view.pickup

import androidx.lifecycle.ViewModel
import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.usecase.RequestPickUp
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PickUpViewModel @Inject constructor(
    private val requestPickUp: RequestPickUp
) : ViewModel() {
    fun addPickUp(
        name: String,
        type: String,
        berat: Int,
        harga: Int,
        tanggal: String,
        alamat: String,
        catatan: String
    ) {
        Completable.fromAction {
            val pickUp = PickUp(
                name = name,
                type = type,
                berat = berat,
                harga = harga,
                tanggal = tanggal,
                alamat = alamat,
                catatan = catatan
            )
            requestPickUp(pickUp)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe()
    }
}
