package com.frogobox.minimummvvm

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/*
 * Created by faisalamir on 08/02/22
 * recyclercoroutines
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 Mona Primaveras Inc.      
 * All rights reserved
 *
 */

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val data = mutableListOf<MainData>()

    private var _mainData = MutableLiveData<MutableList<MainData>>()
    var mainData: LiveData<MutableList<MainData>> = _mainData

    fun setupData() {
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        data.add(MainData("Faisal Amir", 24))
        _mainData.postValue(data)
    }

}