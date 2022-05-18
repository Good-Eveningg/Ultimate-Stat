package com.example.ultimatestat.screens.PlayerStat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ultimatestat.R
import com.example.ultimatestat.databinding.FragmentPlayerStatBinding


class PlayerStat : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bindig = DataBindingUtil.inflate<FragmentPlayerStatBinding>(
            inflater, R.layout.fragment_player_stat,
            container, false
        )
        return bindig.root
    }
}
