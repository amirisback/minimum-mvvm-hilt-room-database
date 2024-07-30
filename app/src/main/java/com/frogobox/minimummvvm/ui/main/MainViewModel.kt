package com.frogobox.minimummvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frogobox.minimummvvm.data.repository.ContactRepository
import com.frogobox.minimummvvm.data.repository.ContactRepositoryImpl
import com.frogobox.minimummvvm.model.ContactModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
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
class MainViewModel @Inject constructor(
    private val repository: ContactRepository
) : ViewModel() {

    private val data = mutableListOf<ContactModel>()

    private var _mainData = MutableLiveData<MutableList<ContactModel>>()
    var mainData: LiveData<MutableList<ContactModel>> = _mainData

    fun setupData() {
        data.add(ContactModel(name = "Faisal Amir", age = 24))
        data.add(ContactModel(name = "Faisal Amir", age = 24))
        data.add(ContactModel(name = "Faisal Amir", age = 24))
        data.add(ContactModel(name = "Faisal Amir", age = 24))
        data.add(ContactModel(name = "Faisal Amir", age = 24))
        data.add(ContactModel(name = "Faisal Amir", age = 24))
        _mainData.postValue(data)
        data.forEach {
            insertContact(it)
        }
    }

    fun insertContact(data: ContactModel) {
        viewModelScope.launch {
            repository.insertContact(data)
                .onEach {
                    // _contactsState.postValue(it)
                }
                .launchIn(viewModelScope)
        }
    }

}