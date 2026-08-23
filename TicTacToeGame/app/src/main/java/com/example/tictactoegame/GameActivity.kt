package com.example.tictactoegame

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoegame.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityGameBinding
    private var gameModel: GameModel? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btn0.setOnClickListener { this }
        binding.btn1.setOnClickListener { this }
        binding.btn2.setOnClickListener { this }
        binding.btn3.setOnClickListener { this }
        binding.btn4.setOnClickListener { this }
        binding.btn5.setOnClickListener { this }
        binding.btn6.setOnClickListener { this }
        binding.btn7.setOnClickListener { this }
        binding.btn8.setOnClickListener { this }

        binding.btnStartGame.setOnClickListener {
            StartGame()
        }

        GameData.gameModel.observe(this){
            gameModel =it
            setUI()

        }

    }

    fun setUI(){
        gameModel?.apply {
            binding.btn0.text=filledPos[0]
            binding.btn1.text=filledPos[1]
            binding.btn2.text=filledPos[2]
            binding.btn3.text=filledPos[3]
            binding.btn4.text=filledPos[4]
            binding.btn5.text=filledPos[5]
            binding.btn6.text=filledPos[6]
            binding.btn7.text=filledPos[7]
            binding.btn8.text=filledPos[8]

            binding.gameStatusText.text=
                when(gameStatus){
                    GameStatus.CREATED ->{
                        "Game ID :"+gameId
                    }

                    GameStatus.JOINED->{
                        "Click on Start game"
                    }

                    GameStatus.IMPROGRESS ->{
                        currentPlayer +" turn"
                    }

                    GameStatus.FINISHED->{
                        if(winner.isNotEmpty())winner+"win"
                        else "DRAW"
                    }

                }
        }

    }
    fun StartGame(){

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}