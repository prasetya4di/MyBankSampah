package com.project.banksampah.view.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.banksampah.model.entity.PickUp
import com.project.banksampah.usecase.DeletePickUp
import com.project.banksampah.usecase.GetAllPickUp
import com.project.banksampah.usecase.GetTotalBalance
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    getAllPickUp: GetAllPickUp,
    getTotalBalance: GetTotalBalance,
    private val deletePickUp: DeletePickUp
) : ViewModel() {
    var totalSaldo: LiveData<Int> = getTotalBalance()
    var pickUps: LiveData<List<PickUp>> = getAllPickUp()

    fun deletePickUp(pickUp: PickUp) {
        Completable.fromAction {
            deletePickUp(pickUp)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe()
    }
}
