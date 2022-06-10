package com.project.banksampah.di.modules

import com.project.banksampah.data.local.pickup.PickUpDao
import com.project.banksampah.repository.PickUpRepository
import com.project.banksampah.repository.impl.PickUpRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providePickUpRepository(pickUpDao: PickUpDao): PickUpRepository =
        PickUpRepositoryImpl(pickUpDao)
}
