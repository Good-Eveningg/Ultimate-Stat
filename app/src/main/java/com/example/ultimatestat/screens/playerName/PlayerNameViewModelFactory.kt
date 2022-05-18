package com.example.ultimatestat.screens.playerName

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ultimatestat.db.repository.PlayersRepoRealization

class PlayerNameViewModelFactory(
    private val context: Context,
    private val playersRepoRealization: PlayersRepoRealization
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlayerNameViewModel(context, playersRepoRealization) as T
    }

}