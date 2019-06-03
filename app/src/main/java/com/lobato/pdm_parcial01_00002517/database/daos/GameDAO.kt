package com.lobato.pdm_parcial01_00002517.database.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lobato.pdm_parcial01_00002517.database.entities.Game


@Dao
interface GameDAO {
    @Query("SELECT *FROM Game")
    fun getAllGames():LiveData<List<Game>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: Game)

    @Update
    fun updateGame(game: Game)

    @Query("DELETE FROM Game")
    fun deleteGames()
}