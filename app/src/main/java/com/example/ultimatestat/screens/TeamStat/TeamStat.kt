package com.example.ultimatestat.screens.TeamStat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.ultimatestat.R
import com.example.ultimatestat.databinding.FragmentTeamStatBinding


class TeamStat : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = DataBindingUtil.inflate<FragmentTeamStatBinding>(
           inflater, R.layout.fragment_team_stat,
           container, false
       )
        return binding.root
    }


}