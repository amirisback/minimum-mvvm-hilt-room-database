package com.frogobox.minimummvvm.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


/**
 * Created by faisalamir on 07/02/22
 * recyclercoroutines
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 FrogoBox Inc.      
 * All rights reserved
 *
 */


@Parcelize
@Keep
@Entity("ContactTable")
data class ContactModel(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "table_id")
    var table_id: Int = 0,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "phone")
    var phone: String = "",

    @ColumnInfo(name = "age")
    var age: Int = 0,

    @ColumnInfo(name = "gender")
    var gender: String = "",

    @ColumnInfo(name = "hobby")
    var hobby: String = "",

    ) : Parcelable
