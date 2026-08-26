package com.example.tictactoegame

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoegame.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnPlayOffline.setOnClickListener {
            createOfflienGame()
        }
        binding.btnCreateOnlineGame.setOnClickListener {
            createOnlienGame()
        }
        binding.btnJoinOnline.setOnClickListener {
            JoinOnlineGame()
        }
    }
    fun createOfflienGame(){
        GameData.saveGameModel(
            GameModel(
                gameStatus = GameStatus.JOINED
            )
        )
        startGame()

    }


    fun createOnlienGame(){
        GameData.myID="X"
        GameData.saveGameModel(
            GameModel(
                gameStatus = GameStatus.CREATED,
                gameId = Random.nextInt(1000,10000).toString()


            )
        )
        startGame()

    }

    fun JoinOnlineGame(){
        var gameId=binding.gameIdInput.text.toString()
        if(gameId.isEmpty()){
            binding.gameIdInput.setError("Please Enter Game Id")
            return
        }
        GameData.myID="O"
        Firebase.firestore.collection("games")
            .document(gameId)
            .get()
            .addOnSuccessListener{
                val model=it?.toObject(GameModel::class.java)
                if(model==null){
                    binding.gameIdInput.setError("Please Enter Valid  Game Id")
                }else{
                    model.gameStatus= GameStatus.JOINED
                    GameData.saveGameModel(model)
                    startGame()
                }
            }
    }
    fun startGame(){
        startActivity(Intent(this, GameActivity::class.java))

    }


}