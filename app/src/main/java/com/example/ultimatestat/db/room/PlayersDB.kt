package com.example.ultimatestat.db.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ultimatestat.db.dao.PlayersDao
import com.example.ultimatestat.model.PlayersModel

@Database(entities = [PlayersModel::class], version = 1)
abstract class PlayersDB : RoomDatabase() {
    abstract fun getPlayersDao(): PlayersDao

    companion object {
        private var database: PlayersDB? = null

//        @Synchronized
//        fun getInstance(context: Context): PlayersDB {
//
//            return if (database == null) {
//                database = Room.databaseBuilder(
//                    context,
//                    PlayersDB::class.java,
//                    "players"
//                ).build()
//                database as PlayersDB
//            } else {
//                database as PlayersDB
//            }
//        }

        @Volatile
        private var INSTANCE: PlayersDB? = null

        fun getInstance(context: Context): PlayersDB {
            val currentInstance = INSTANCE
            if (currentInstance != null) {
                return currentInstance
            }

            synchronized(this) {
                val dataBaseInstance = INSTANCE
                return if (dataBaseInstance != null) {
                    dataBaseInstance
                } else {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        PlayersDB::class.java,
                        "user_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
            }
        }

    }
}