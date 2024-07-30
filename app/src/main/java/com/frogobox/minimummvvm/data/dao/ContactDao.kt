package com.frogobox.minimummvvm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.frogobox.minimummvvm.model.ContactModel

/**
 * Created by faisalamircs on 30/07/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Dao
interface ContactDao {

    @Query("SELECT * FROM ContactTable")
    fun getAllData(): List<ContactModel>

    @Insert
    fun insertData(data: ContactModel)

    @Query("DELETE FROM ContactTable WHERE table_id = :tableId")
    fun deleteDataFromTableId(tableId: Int)

    @Query("DELETE FROM ContactTable")
    fun nukeData()

}