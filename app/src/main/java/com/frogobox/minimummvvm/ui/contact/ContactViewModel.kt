package com.frogobox.minimummvvm.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frogobox.minimummvvm.data.repository.ContactRepository
import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by faisalamircs on 30/07/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@HiltViewModel
class ContactViewModel @Inject constructor(
    private val repository: ContactRepository
) : ViewModel() {

    private var _contactsState = MutableLiveData<Resource<List<ContactModel>>>()
    var contactsState: LiveData<Resource<List<ContactModel>>> = _contactsState

    private var _insertState = MutableLiveData<Resource<ContactModel>>()
    var insertState: LiveData<Resource<ContactModel>> = _insertState


    fun getContacts() {
        viewModelScope.launch {
            repository.getContacts()
                .onEach {
                    _contactsState.postValue(it)
                }
                .launchIn(viewModelScope)
        }
    }

    fun insertContact(data: ContactModel) {
        viewModelScope.launch {
            repository.insertContact(data)
                .onEach {
                    _insertState.postValue(it)
                }
                .launchIn(viewModelScope)
        }
    }

    fun insertDummy() {
        val dummy = ContactModel(
            name = "Peter",
            phone = "08123456789",
            age = 27,
            gender = "Male",
            hobby = "Basket"
        )
        insertContact(dummy)
    }

}