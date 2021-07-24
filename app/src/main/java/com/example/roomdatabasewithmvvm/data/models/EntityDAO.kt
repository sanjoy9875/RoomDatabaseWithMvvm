package com.example.roomdatabasewithmvvm.data.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EntityDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addEntity(responseEntity: List<ResponseEntity>)

    @Query("select * from entity")
    fun getEntity(): LiveData<List<ResponseEntity>>

}