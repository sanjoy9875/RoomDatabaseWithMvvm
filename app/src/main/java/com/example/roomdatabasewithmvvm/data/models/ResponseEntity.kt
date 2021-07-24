package com.example.roomdatabasewithmvvm.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "entity")
data class ResponseEntity(

    @SerializedName("image")
    @ColumnInfo(name = "image")
    var image: String,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    var title: String,

    @SerializedName("subTitle")
    @ColumnInfo(name = "subTitle")
    var subTitle: String,

) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int? = null

}