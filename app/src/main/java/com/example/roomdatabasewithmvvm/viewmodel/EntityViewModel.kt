package com.example.roomdatabasewithmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.roomdatabasewithmvvm.data.models.ResponseEntity
import com.example.roomdatabasewithmvvm.repository.EntityRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EntityViewModel(val repository: EntityRepository) : ViewModel(){

    /**
     * Getting the response from api
     * */
    fun getResponse(){
        CoroutineScope(Dispatchers.IO).launch {
            repository.getResponse()
        }
    }

    /**
     * getting the list of ResponseEntity
     * */
    fun getEntity(): LiveData<List<ResponseEntity>> {
        return repository.getEntity()
    }



}