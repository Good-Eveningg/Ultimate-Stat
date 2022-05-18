package com.example.ultimatestat.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ultimatestat.R
import com.example.ultimatestat.model.PlayersModel
import kotlinx.android.synthetic.main.item_layout.view.*


class PlayerAdapter: RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    var listPlayer = emptyList<PlayersModel>()
    class PlayerViewHolder (view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.itemView.numberTextView.text = listPlayer[position].number
        holder.itemView.lastNameTextView.text = listPlayer[position].lastName
    }

    override fun getItemCount(): Int {
        return listPlayer.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setList (list: List<PlayersModel>){
        listPlayer = list
        notifyDataSetChanged()
    }
}