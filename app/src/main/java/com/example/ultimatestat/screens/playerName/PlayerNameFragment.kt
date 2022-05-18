package com.example.ultimatestat.screens.playerName

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ultimatestat.R
import com.example.ultimatestat.adapter.PlayerAdapter
import com.example.ultimatestat.databinding.FragmentPlayerNameBinding
import com.example.ultimatestat.db.repository.PlayersRepoRealization
import com.example.ultimatestat.db.room.PlayersDB


class PlayerNameFragment : Fragment() {

    lateinit var binding: FragmentPlayerNameBinding
    private val adapter: PlayerAdapter by lazy { PlayerAdapter() }

    private val playersRepoRealization by lazy {
        PlayersRepoRealization(PlayersDB.getInstance(requireContext()).getPlayersDao())
    }

    private val playerNameViewModel: PlayerNameViewModel by lazy {
        ViewModelProvider(viewModelStore, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return PlayerNameViewModel(playersRepoRealization) as T
            }
        }).get(PlayerNameViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_player_name,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        binding.floatingActionButton.setOnClickListener {
            addPlayer()
        }
        playerNameViewModel.playerLiveData.observe(viewLifecycleOwner) {
            adapter.setList(it)
        }
        playerNameViewModel.getAllPlayers()
    }

    private fun init() {
//        val viewModel = ViewModelProvider(this).get(PlayerNameViewModel::class.java)
//        playerNameViewModel.initDatabase()
        binding.playerName.adapter = adapter
//        playerNameViewModel.getAllPlayers().observe(viewLifecycleOwner) { playerNotes ->
//            playerNotes.asReversed()
//            adapter.setList(playerNotes)
//        }
    }

    private fun addPlayer() {
        val builder: AlertDialog.Builder = android.app.AlertDialog.Builder(context)
        builder.setTitle("Игрок")

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL

        val playerNumber = EditText(context)
        playerNumber.setHint("Введите игровой номер")
        playerNumber.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(playerNumber)

        val playerLastName = EditText(context)
        playerLastName.setHint("Введите фамилию")
        playerLastName.inputType = InputType.TYPE_CLASS_TEXT
        layout.addView(playerLastName)
        layout.setPadding(50, 40, 50, 10)
        builder.setView(layout)

        builder.setPositiveButton("Создать", DialogInterface.OnClickListener { dialog, which ->
            var playerNumber = playerNumber.text.toString()
            var playerLastName = playerLastName.text.toString()
        })
        builder.setNegativeButton(
            "Отмена",
            DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }

}

