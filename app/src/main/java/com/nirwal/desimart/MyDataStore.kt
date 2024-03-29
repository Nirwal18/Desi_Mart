package com.nirwal.desimart

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*


class MyDataStore(private val context: Context) {

    companion object{
        val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    }

    fun getInt(key: String, defaultValue: Int): Flow<Int> {
        return context.dataStore.data.map {
            it[intPreferencesKey(key)] ?: defaultValue
        }
    }

    fun getBoolean(key: String, defaultValue: Boolean): Flow<Boolean> {
        return context.dataStore.data.map {
            it[booleanPreferencesKey(key)] ?: defaultValue
        }
    }

    fun getString(key: String, defaultValue: String): Flow<String> {
        return context.dataStore.data.map {
            it[stringPreferencesKey(key)] ?: defaultValue
        }
    }


    suspend fun saveInt(key: String, value: Int) {
        context.dataStore.edit { settings ->
            settings[intPreferencesKey(key)] = value
        }
    }

    suspend fun saveBoolean(key: String, value: Boolean) {
        context.dataStore.edit { settings ->
            settings[booleanPreferencesKey(key)] = value
        }
    }

    suspend fun saveString(key: String, value: String) {
        context.dataStore.edit { settings ->
            settings[stringPreferencesKey(key)] = value
        }
    }

}


