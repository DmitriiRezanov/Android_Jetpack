package com.example.androidjetpack.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidjetpack.R
import com.example.androidjetpack.databinding.FragmentGameBinding
import com.example.androidjetpack.domain.entity.GameResult
import com.example.androidjetpack.domain.entity.GameSettings
import com.example.androidjetpack.domain.entity.Level


class GameFragment : Fragment() {


    private lateinit var level: Level

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding = null")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gameSettings = GameSettings(
            1,
            1,
            1,
            1
        )
        val gameResult = GameResult(
            true,
            1,
            1,
            gameSettings
        )
        binding.tvLeftNumber.setOnClickListener {
            launchGameFinishedFragment(gameResult)
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult){
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun parseArgs(){
        requireArguments().getParcelable<Level>(KEY_LEVEL)?.let {
            level = it
        }
    }


    companion object {

        private const val KEY_LEVEL = "level"
        const val NAME_FRAGMENT = "GameFragment"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }

        }
    }
}