package com.frogobox.minimummvvm.di

import android.content.Context
import com.frogobox.minimummvvm.data.dao.ContactDao
import com.frogobox.minimummvvm.data.db.RecentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): RecentDatabase =
        RecentDatabase.getInstance(context)

    @Provides
    fun provideContactDao(database: RecentDatabase): ContactDao = database.contactDao()

}