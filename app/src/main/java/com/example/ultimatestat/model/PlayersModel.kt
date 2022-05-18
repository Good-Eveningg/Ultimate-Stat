package com.example.ultimatestat.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "players_table")
class PlayersModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo
    var nuber: String = "",
    @ColumnInfo
    var lastName: String = ""
)

