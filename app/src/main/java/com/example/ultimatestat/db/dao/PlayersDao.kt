package com.example.ultimatestat.db.dao

import androidx.room.*
import com.example.ultimatestat.model.PlayersModel

@Dao
interface PlayersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(playersModel: PlayersModel)

    @Update
    suspend fun update(playersModel: PlayersModel)

    @Delete
    suspend fun delete(playersModel: PlayersModel)

    @Query("SELECT * from players_table")
    fun getAllPlayers(): List<PlayersModel>

}