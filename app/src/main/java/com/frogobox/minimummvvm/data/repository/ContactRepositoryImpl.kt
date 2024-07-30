package com.frogobox.minimummvvm.data.repository

import com.frogobox.minimummvvm.data.db.ContactDaoSource
import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Created by faisalamircs on 30/07/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class ContactRepositoryImpl @Inject constructor(
    private val daoSource: ContactDaoSource,
) : ContactRepository {

    override suspend fun insertContact(data: ContactModel): Flow<Resource<ContactModel>> {
        return daoSource.insertContact(data).map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: ContactModel())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

    override suspend fun getContacts(): Flow<Resource<List<ContactModel>>> {
        return daoSource.getContacts().map {
            return@map when (it) {
                is Resource.Success -> Resource.Success(it.data ?: listOf())
                is Resource.Error -> Resource.Error(it.message.toString())
                is Resource.Loading -> Resource.Loading()
            }
        }
    }

}