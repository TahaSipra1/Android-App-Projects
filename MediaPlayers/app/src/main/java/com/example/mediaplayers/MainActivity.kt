package com.example.mediaplayers

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {

    lateinit var mediaPlayer: MediaPlayer
    var totaltime:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mediaPlayer= MediaPlayer.create(this,R.raw.barsaat)
        mediaPlayer.setVolume(1f,1f)
        totaltime=mediaPlayer.duration

        val play=findViewById<ImageView>(R.id.imagePlay)
        val pause=findViewById<ImageView>(R.id.imagePause)
        val stop=findViewById<ImageView>(R.id.imageStop)
        val seekbarMusic=findViewById<SeekBar>(R.id.seekBar)

        play.setOnClickListener {
            mediaPlayer.start()
        }

        pause.setOnClickListener {
            mediaPlayer.pause()
        }

        stop.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
        }

        //When user changes the time stamp of music,reflect that changes
        seekbarMusic.max=totaltime
        seekbarMusic.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromuser: Boolean) {
                if(fromuser)
                {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        //chnage the seekbar position based on music
        val handler = android.os.Handler()
        handler.postDelayed(object: Runnable {
            override fun run() {
                try {
                    seekbarMusic.progress=mediaPlayer.currentPosition
                    handler.postDelayed(this,1000)
                }
                catch (exception:java.lang.Exception){
                    seekbarMusic.progress=0
                }
            }
        },0)


    }
}