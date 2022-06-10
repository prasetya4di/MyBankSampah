package com.project.banksampah.di.modules

import com.project.banksampah.repository.PickUpRepository
import com.project.banksampah.repository.impl.PickUpRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPickUpRepository(
        pickUpRepositoryImpl: PickUpRepositoryImpl
    ): PickUpRepository
}
