package com.example.roomdatabasewithmvvm.data.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ResponseEntity::class], version = 1)
abstract class EntityDatabase : RoomDatabase() {

    abstract fun getEntityDao(): EntityDAO

    companion object{

        private var INSTANCE : EntityDatabase? = null

        fun getRoomDatabase(context: Context): EntityDatabase{

            if (INSTANCE == null){

                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    EntityDatabase::class.java,
                    "entity_database")

                builder.fallbackToDestructiveMigration()
                INSTANCE =  builder.build()
                return INSTANCE!!
            }else{
                return INSTANCE!!
            }

        }

    }

}