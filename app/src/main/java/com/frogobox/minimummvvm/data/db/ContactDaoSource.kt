package com.frogobox.minimummvvm.data.db

import com.frogobox.minimummvvm.data.dao.ContactDao
import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by faisalamircs on 15/12/2023
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@Singleton
class ContactDaoSource @Inject constructor(
    private val contactDao: ContactDao,
) {
    suspend fun insertContact(data: ContactModel): Flow<Resource<ContactModel>> = flow {
        try {
            emit(Resource.Loading())
            contactDao.insertData(data)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)


    suspend fun getContacts(): Flow<Resource<List<ContactModel>>> = flow {
        try {
            emit(Resource.Loading())
            val response = contactDao.getAllData()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}