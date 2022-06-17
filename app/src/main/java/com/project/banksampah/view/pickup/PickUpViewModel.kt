package com.project.banksampah.view.pickup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.usecase.RequestPickUp
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PickUpViewModel @Inject constructor(
    private val requestPickUp: RequestPickUp
) : ViewModel() {
    private var _name: MutableLiveData<String> = MutableLiveData()
    private var _pickUpDate: MutableLiveData<Date> = MutableLiveData()
    private var _address: MutableLiveData<String> = MutableLiveData()
    private var _note: MutableLiveData<String> = MutableLiveData()
    private var _weight: MutableLiveData<Int> = MutableLiveData()
    private var _totalPrice: MutableLiveData<Int> = MutableLiveData()
    private var _selectedCategory: MutableLiveData<String> = MutableLiveData()
    private var _pricePerKg: MutableLiveData<Int> = MutableLiveData()

    init {
        _totalPrice.value = 0
        _pricePerKg.value = 0
    }

    val name: LiveData<String>
        get() = _name
    val pickUpDate: LiveData<Date>
        get() = _pickUpDate
    val address: LiveData<String>
        get() = _address
    val note: LiveData<String>
        get() = _note
    val totalPrice: LiveData<Int>
        get() = _totalPrice
    val selectedCategory: LiveData<String>
        get() = _selectedCategory
    val pricePerKg: LiveData<Int>
        get() = _pricePerKg
    val weight: LiveData<Int>
        get() = _weight

    fun setSelectedCategory(selectedCategory: String, pricePerKg: Int) {
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

    fun setName(name: String) {
        _name.postValue(name)
    }

    fun setPickUpDate(date: Date) {
        _pickUpDate.postValue(date)
    }

    fun setAddress(address: String) {
        _address.postValue(address)
    }

    fun setNote(note: String) {
        _note.postValue(note)
    }

    fun addPickUp() {
        Completable.fromAction {
            val pickUp = PickUp(
                name = name.value!!,
                type = selectedCategory.value!!,
                berat = weight.value!!,
                harga = totalPrice.value!!,
                tanggal = pickUpDate.value!!,
                alamat = address.value!!.toString(),
                catatan = note.value
            )
            requestPickUp(pickUp)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe()
    }
}
