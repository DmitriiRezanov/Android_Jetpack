package com.example.androidjetpack.domain.usecases

import com.example.androidjetpack.domain.entity.GameSettings
import com.example.androidjetpack.domain.entity.Level
import com.example.androidjetpack.domain.repository.GameRepository

class GetGameSettingsUseCase (private val repository: GameRepository) {

    operator fun invoke(level: Level):GameSettings{
        return repository.getGameSettings(level)
    }
}