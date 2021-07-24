package com.example.roomdatabasewithmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.roomdatabasewithmvvm.models.ResponseEntity
import com.example.roomdatabasewithmvvm.repository.EntityRepository
import kotlinx.coroutines.Dispatchers


class EntityViewModel(val repository: EntityRepository) : ViewModel(){

    fun getResponse() : LiveData<List<ResponseEntity>>{
        return liveData(Dispatchers.IO){
            val result = repository.getResponse()
            emit(result.data!!)
        }
    }

    fun addEntity(responseEntity: List<ResponseEntity>){
        repository.addEntity(responseEntity)
    }

    fun getEntity(): LiveData<List<ResponseEntity>> {
        return repository.getEntity()
    }



}