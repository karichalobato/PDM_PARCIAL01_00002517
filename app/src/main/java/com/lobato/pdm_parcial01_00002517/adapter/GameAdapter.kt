package com.lobato.pdm_parcial01_00002517.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lobato.pdm_parcial01_00002517.R
import com.lobato.pdm_parcial01_00002517.database.entities.Game

abstract class GameAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    abstract fun addListener(holder: GameViewHolder, team1: String, team2: String, point1: Int, point2: Int)

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var games = emptyList<Game>()
    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val team1: TextView = itemView.findViewById(R.id.tv_team1)
        val team2: TextView = itemView.findViewById(R.id.tv_team2)
        val score1: TextView = itemView.findViewById(R.id.tv_point1)
        val score2: TextView = itemView.findViewById(R.id.tv_point2)
        val game_container: LinearLayout = itemView.findViewById(R.id.item_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = inflater.inflate(R.layout.recycle_view_item, parent, false)
        return GameViewHolder(itemView)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val current = games[position]
        holder.team1.text = current.team01
        holder.team2.text = current.team02
        holder.score1.text = current.score01.toString()
        holder.score2.text = current.score02.toString()

        addListener(holder,current.team01,current.team02, current.score01, current.score02)

    }

    internal fun setGames(games: List<Game>) {
        this.games = games
        notifyDataSetChanged()
    }


    override fun getItemCount() = games.size
}