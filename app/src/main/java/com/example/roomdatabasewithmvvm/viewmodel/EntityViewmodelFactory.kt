package com.example.roomdatabasewithmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasewithmvvm.repository.EntityRepository

class EntityViewmodelFactory(val repository: EntityRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EntityViewModel(repository) as T
    }
}