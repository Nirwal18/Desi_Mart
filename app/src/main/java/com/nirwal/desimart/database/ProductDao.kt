package com.nirwal.desimart.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun insert(product:ProductEntity)

    @Delete
    fun delete(product:ProductEntity)

    @Query("DELETE FROM ProductEntity")
    fun deleteAll()

    @Query("SELECT * from ProductEntity")
    fun getAll():List<ProductEntity>

}