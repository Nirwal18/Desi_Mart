package com.nirwal.desimart.database

import androidx.room.Entity

@Entity
data class ProductEntity(
    val uid:Int = 0,
    val remoteId:String,
    val name:String,
    val desc:String,
    val imageUrl:String
)