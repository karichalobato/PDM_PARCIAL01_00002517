package com.lobato.pdm_parcial01_00002517.repository

import androidx.lifecycle.LiveData
import com.lobato.pdm_parcial01_00002517.database.daos.GameDAO
import com.lobato.pdm_parcial01_00002517.database.entities.Game

class GameRepository ( private val gameDAO:GameDAO){

    val allGame: LiveData<List<Game>> = gameDAO.getAllGames()

    suspend fun insert(game: Game){
        gameDAO.insertGame(game)
    }

    suspend fun update(game: Game){
        gameDAO.updateGame(game)
    }
}