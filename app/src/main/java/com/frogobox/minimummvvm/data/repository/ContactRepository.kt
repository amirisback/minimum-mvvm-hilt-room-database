package com.frogobox.minimummvvm.data.repository

import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by faisalamircs on 30/07/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


interface ContactRepository {

    suspend fun insertContact(data: ContactModel): Flow<Resource<ContactModel>>

    suspend fun getContacts(): Flow<Resource<List<ContactModel>>>

}