package com.example.ultimatestat.db.repository

import androidx.lifecycle.LiveData
import com.example.ultimatestat.model.PlayersModel

interface PlayersRepository {
    val allPlayers: List<PlayersModel>
    suspend fun insertPlayer (playersModel: PlayersModel, onSuccess : () -> Unit)
    suspend fun changePlayer (playersModel: PlayersModel, onSuccess : () -> Unit)
    suspend fun deletePlayer (playersModel: PlayersModel,onSuccess : () -> Unit)
}