package com.example.androidjetpack.domain.repository

import com.example.androidjetpack.domain.entity.GameSettings
import com.example.androidjetpack.domain.entity.Level
import com.example.androidjetpack.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}