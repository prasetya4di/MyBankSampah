package com.project.banksampah.view.pickup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
    private var _weight: MutableLiveData<Int> = MutableLiveData()
    private var _totalPrice: MutableLiveData<Int> = MutableLiveData()
    private var _selectedCategory: MutableLiveData<Int> = MutableLiveData()
    private var _pricePerKg: MutableLiveData<Int> = MutableLiveData()

    init {
        _totalPrice.value = 0
        _selectedCategory.value = 0
        _pricePerKg.value = 0
    }

    val totalPrice: LiveData<Int> = _totalPrice
    val selectedCategory: LiveData<Int> = _selectedCategory
    val pricePerKg: LiveData<Int> = _pricePerKg
    val weight: LiveData<Int> = _weight

    fun setSelectedCategory(selectedCategory: Int, pricePerKg: Int) {
        _selectedCategory.postValue(selectedCategory)
        _pricePerKg.postValue(pricePerKg)
        if (weight.value != null) {
            _totalPrice.postValue(weight.value!!.times(pricePerKg))
        }
    }

    fun changeKg(kg: Int) {
        _weight.postValue(kg)
        if (pricePerKg.value != null) {
            _totalPrice.postValue(kg.times(pricePerKg.value!!))
        }
    }

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
