package com.example.ultimatestat.db.repository

import com.example.ultimatestat.model.PlayersModel

interface PlayersRepository {
    suspend fun getAllUsers(): List<PlayersModel>
//    suspend fun insertPlayer(playersModel: PlayersModel, onSuccess: () -> Unit)
//    suspend fun changePlayer(playersModel: PlayersModel, onSuccess: () -> Unit)
//    suspend fun deletePlayer(playersModel: PlayersModel, onSuccess: () -> Unit)
}