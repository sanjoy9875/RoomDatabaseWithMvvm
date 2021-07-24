package com.example.roomdatabasewithmvvm.data.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface EntityDAO {

    /**
     * This function list of item into our Database
     * */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEntity(responseEntity: List<ResponseEntity>)

    /**
     * This function fetch the list of item from our Database
     * */
    @Query("select * from entity")
    fun getEntity(): LiveData<List<ResponseEntity>>

}