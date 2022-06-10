package com.project.banksampah.di.modules

import com.project.banksampah.repository.PickUpRepository
import com.project.banksampah.usecase.DeletePickUp
import com.project.banksampah.usecase.GetAllPickUp
import com.project.banksampah.usecase.GetTotalBalance
import com.project.banksampah.usecase.RequestPickUp
import com.project.banksampah.usecase.impl.DeletePickUpImpl
import com.project.banksampah.usecase.impl.GetAllPickUpImpl
import com.project.banksampah.usecase.impl.GetTotalBalanceImpl
import com.project.banksampah.usecase.impl.RequestPickUpImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideRequestPickUp(
        pickUpRepository: PickUpRepository
    ): RequestPickUp = RequestPickUpImpl(pickUpRepository)

    @Provides
    @Singleton
    fun provideGetAllPickUp(
        pickUpRepository: PickUpRepository
    ): GetAllPickUp = GetAllPickUpImpl(pickUpRepository)

    @Provides
    @Singleton
    fun provideDeletePickUp(
        pickUpRepository: PickUpRepository
    ): DeletePickUp = DeletePickUpImpl(pickUpRepository)

    @Provides
    @Singleton
    fun provideGetTotalBalance(
        pickUpRepository: PickUpRepository
    ): GetTotalBalance = GetTotalBalanceImpl(pickUpRepository)
}
