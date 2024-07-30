package com.frogobox.minimummvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.frogobox.minimummvvm.BuildConfig
import com.frogobox.minimummvvm.data.dao.ContactDao
import com.frogobox.minimummvvm.model.ContactModel

/**
 * Created by faisalamircs on 15/12/2023
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Database(
    entities = [
        (ContactModel::class)
    ], version = 1
)

abstract class RecentDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

        @Volatile
        private var INSTANCE: RecentDatabase? = null

        fun getInstance(context: Context): RecentDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabase(context: Context): RecentDatabase {
            return if (BuildConfig.DEBUG) {
                Room.databaseBuilder(
                    context.applicationContext,
                    RecentDatabase::class.java,
                    "db_contact_mini"
                )
                    .fallbackToDestructiveMigration() // FOR DEVELOPMENT ONLY !!!!
                    .build()
            } else {
                Room.databaseBuilder(
                    context.applicationContext,
                    RecentDatabase::class.java,
                    "db_contact_mini"
                )
                    .build()
            }
        }
    }
}