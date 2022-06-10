package com.project.banksampah.di.modules

import com.project.banksampah.usecase.DeletePickUp
import com.project.banksampah.usecase.GetAllPickUp
import com.project.banksampah.usecase.RequestPickUp
import com.project.banksampah.usecase.impl.DeletePickUpImpl
import com.project.banksampah.usecase.impl.GetAllPickUpImpl
import com.project.banksampah.usecase.impl.RequestPickUpImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindRequestPickUp(
        requestPickUpImpl: RequestPickUpImpl
    ): RequestPickUp

    @Binds
    abstract fun bindGetAllPickUp(
        getAllPickUpImpl: GetAllPickUpImpl
    ): GetAllPickUp

    @Binds
    abstract fun bindDeletePickUp(
        deletePickUpImpl: DeletePickUpImpl
    ): DeletePickUp
}
