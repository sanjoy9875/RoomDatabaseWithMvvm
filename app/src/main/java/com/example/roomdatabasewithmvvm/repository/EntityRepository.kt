package com.example.roomdatabasewithmvvm.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabasewithmvvm.data.models.EntityDAO
import com.example.roomdatabasewithmvvm.data.models.ResponseEntity
import com.example.roomdatabasewithmvvm.data.remote.APIService
import com.example.roomdatabasewithmvvm.data.remote.Resource
import com.example.roomdatabasewithmvvm.data.remote.ResponseHandler
import com.example.roomdatabasewithmvvm.data.remote.RetrofitGenerator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntityRepository(val entityDAO: EntityDAO) {

    val CONTENT_TYPE = "application/json"
    val api = RetrofitGenerator.getInstance().create(APIService::class.java)

    val responseHandler = ResponseHandler()

    suspend fun getResponse() : Resource<List<ResponseEntity>> {
        val result = api.getEntity(CONTENT_TYPE)

        return responseHandler.handleSuccess(result)
    }

    fun addEntity(responseEntity: List<ResponseEntity>){
        CoroutineScope(Dispatchers.IO).launch{
            entityDAO.addEntity(responseEntity)
        }
    }

    fun getEntity(): LiveData<List<ResponseEntity>> {
        return entityDAO.getEntity()
    }



}