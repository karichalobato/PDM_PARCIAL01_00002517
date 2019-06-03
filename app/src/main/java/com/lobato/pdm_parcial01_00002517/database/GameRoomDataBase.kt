package com.lobato.pdm_parcial01_00002517.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.lobato.pdm_parcial01_00002517.database.daos.GameDAO
import com.lobato.pdm_parcial01_00002517.database.entities.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Game::class], version = 1)
abstract class GameRoomDataBase : RoomDatabase() {
    abstract fun gameDAO():GameDAO

    companion object {
        @Volatile
        private var INSTANCE: GameRoomDataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): GameRoomDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GameRoomDataBase::class.java,
                    "Game_DataBae"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(GameDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class GameDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.gameDAO())
                    }
                }
            }
        }

        suspend fun populateDatabase(gameDao: GameDAO) {

            val True:Boolean = true
            val False:Boolean = false

            var game = Game( 1, "Rockets", "Knicks", 140, 120)
            gameDao.insertGame(game)

            game = Game( 2, "Raptors", "Clippers", 130, 130)
            gameDao.insertGame(game)

            game = Game( 3, "Boston Celtics", "Warrios", 120, 120)
            gameDao.insertGame(game)

            game = Game( 4, "Spurs", "Bucks", 160, 110)
            gameDao.insertGame(game)

            game = Game( 5, "Lakers", "Knicks", 130, 120)
            gameDao.insertGame(game)

            game = Game( 6, "Lakers", "Raptors", 140, 120)
            gameDao.insertGame(game)

            game = Game( 7, "Bucks", "Knicks", 130, 160)
            gameDao.insertGame(game)

            game = Game( 8, "Spurs", "Warrios", 120, 130)
            gameDao.insertGame(game)


        }




    }
}