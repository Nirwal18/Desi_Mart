package com.nirwal.desimart.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class MyDatabase: RoomDatabase() {
    companion object{
        var INSTANCE:MyDatabase? = null
        fun getInstance(context:Context):MyDatabase{
            return if(INSTANCE==null){
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context = context,
                        MyDatabase::class.java,
                        "desi_cart_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }else INSTANCE!!

        }
    }
    abstract fun getProductDao():ProductDao
}

fun getProductDao(db:MyDatabase):ProductDao{
    return db.getProductDao()
}