package com.example.ultimatestat.db.repository

import androidx.lifecycle.LiveData
import com.example.ultimatestat.db.dao.PlayersDao
import com.example.ultimatestat.model.PlayersModel

class PlayersRepoRealization(private val playersDao: PlayersDao) : PlayersRepository {

//    override val allPlayers: LiveData<List<PlayersModel>>
//        get() = playersDao.getAllPlayers()

    override val allPlayers = playersDao.getAllPlayers()

    override suspend fun insertPlayer(playersModel: PlayersModel, onSuccess: () -> Unit) {
        playersDao.insert(playersModel)
        onSuccess()
    }

    override suspend fun changePlayer(playersModel: PlayersModel, onSuccess: () -> Unit) {
        playersDao.update(playersModel)
        onSuccess()
    }

    override suspend fun deletePlayer(playersModel: PlayersModel, onSuccess: () -> Unit) {
        playersDao.delete(playersModel)
        onSuccess()
    }

}