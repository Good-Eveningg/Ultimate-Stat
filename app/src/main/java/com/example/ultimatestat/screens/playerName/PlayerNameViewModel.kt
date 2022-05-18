package com.example.ultimatestat.screens.playerName

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ultimatestat.db.repository.PlayersRepoRealization
import com.example.ultimatestat.model.PlayersModel

class PlayerNameViewModel(
    private val repoRealization: PlayersRepoRealization
) : ViewModel() {

    private val mPlayerLiveData = MutableLiveData<List<PlayersModel>>()
    val playerLiveData = mPlayerLiveData

//    fun initDatabase() {
//        val playerDao = PlayersDB.getInstance(context).getPlayersDao()
//        REPOSITORY = PlayersRepoRealization(playerDao)
//    }
//
//    fun getAllPlayers(): LiveData<List<PlayersModel>> {
//        return REPOSITORY.allPlayers
//    }

    fun getAllPlayers() {
        mPlayerLiveData.postValue(repoRealization.allPlayers)
    }

}