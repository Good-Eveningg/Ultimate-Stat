package com.example.ultimatestat.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "players_table")
class PlayersModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    var number: String,

    var lastName: String
)

