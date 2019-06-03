package com.lobato.pdm_parcial01_00002517.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.lobato.pdm_parcial01_00002517.database.GameRoomDataBase
import com.lobato.pdm_parcial01_00002517.database.entities.Game
import com.lobato.pdm_parcial01_00002517.repository.GameRepository
import kotlinx.coroutines.launch

class GameViewModel (application: Application):AndroidViewModel(application) {

    private  val gameRepository:GameRepository
    val allGames:LiveData<List<Game>>

    init {
        val gameDao = GameRoomDataBase.getDatabase(application, viewModelScope)
            .gameDAO()
        gameRepository = GameRepository(gameDao)
        allGames = gameRepository.allGame
    }

    fun insert(game: Game) = viewModelScope.launch {
        gameRepository.insert(game)
    }
}