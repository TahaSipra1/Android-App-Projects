package com.example.tictactoegame

import android.R
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random

object GameData {
    private var _gameModel: MutableLiveData<GameModel > = MutableLiveData()
    var gameModel: LiveData<GameModel> = _gameModel

    fun saveGameModel(model: GameModel){
        _gameModel.postValue(model)
    }


}
