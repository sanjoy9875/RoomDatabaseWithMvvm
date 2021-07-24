package com.example.roomdatabasewithmvvm.view

import android.app.Application
import com.example.roomdatabasewithmvvm.data.models.EntityDatabase
import com.example.roomdatabasewithmvvm.repository.EntityRepository

class EntityApplication : Application() {

    private val entityDAO by lazy {
        val roomDatabase = EntityDatabase.getRoomDatabase(this)
        roomDatabase.getEntityDao()
    }

    val repository by lazy {
        EntityRepository(entityDAO)
    }

}