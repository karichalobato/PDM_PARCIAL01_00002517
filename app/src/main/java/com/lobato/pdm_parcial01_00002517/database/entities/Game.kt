package com.lobato.pdm_parcial01_00002517.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Game")

data class Game (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTeam")
    val idTeam: Int,
    @ColumnInfo(name = "Team01")
    val team01: String,
    @ColumnInfo(name = "Team02")
    val team02: String,
    @ColumnInfo(name = "Score01")
    val score01:Int,
    @ColumnInfo(name = "Score02")
    val score02:Int
)