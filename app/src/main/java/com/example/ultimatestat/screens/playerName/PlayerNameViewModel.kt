package com.example.ultimatestat.screens.playerName

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ultimatestat.db.repository.PlayersRepoRealization
import com.example.ultimatestat.db.room.PlayersDB
import com.example.ultimatestat.model.PlayersModel
import com.example.ultimatestat.screens.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerNameViewModel(
    private val context: Context,
    private val repoRealization: PlayersRepoRealization
) : ViewModel() {

    private val mPlayerLiveData = MutableLiveData<List<PlayersModel>>()
    val playerLiveData = mPlayerLiveData

    fun initDatabase() {
        val playerDao = PlayersDB.getInstance(context).getPlayersDao
        REPOSITORY = PlayersRepoRealization(playerDao)
    }

//    fun getAllPlayers(): LiveData<List<PlayersModel>> {
//        return REPOSITORY.allPlayers
//    }

    fun getAllPlayers() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repoRealization.getAllUsers()
            mPlayerLiveData.postValue(data)
        }
    }

}