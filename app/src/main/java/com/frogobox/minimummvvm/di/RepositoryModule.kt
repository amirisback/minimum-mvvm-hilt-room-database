package com.frogobox.minimummvvm.di

import com.frogobox.minimummvvm.data.repository.ContactRepository
import com.frogobox.minimummvvm.data.repository.ContactRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by faisalamircs on 30/07/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun provideContactRepository(repository: ContactRepositoryImpl): ContactRepository

}