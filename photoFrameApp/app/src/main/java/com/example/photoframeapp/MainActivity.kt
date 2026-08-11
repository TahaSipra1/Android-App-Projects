package com.example.photoframeapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var currentImage=0
    lateinit var image: ImageView
    var names=arrayOf("Virat Kholi","Taha Sipra","Ronaldo")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val prev=findViewById<ImageButton>(R.id.imageBack)
        val next=findViewById<ImageButton>(R.id.imageNext)
        val nametext=findViewById<TextView>(R.id.tvname)

        prev.setOnClickListener {
            val idcurrentImagestring="pic"+currentImage
            //convert string id into integer address associated with it
            val idcurrentImageInt=this.resources.getIdentifier(idcurrentImagestring,"id",packageName)
            image=findViewById(idcurrentImageInt)
            image.alpha=0f
            currentImage=(3+currentImage-1)%3

            val idImagetoshowString="pic"+currentImage
            //convert string id into integer address associated with it
            val idImagetoshowInt=this.resources.getIdentifier(idImagetoshowString,"id",packageName)
            image=findViewById(idImagetoshowInt)
            image.alpha=1f
            //for changing names
            nametext.text=names[currentImage]
        }
        next.setOnClickListener {
            val idcurrentImagestring="pic"+currentImage
            //convert string id into integer address associated with it
            val idcurrentImageInt=this.resources.getIdentifier(idcurrentImagestring,"id",packageName)
            image=findViewById(idcurrentImageInt)
            image.alpha=0f
            currentImage=(3+currentImage+1)%3

            val idImagetoshowString="pic"+currentImage
            //convert string id into integer address associated with it
            val idImagetoshowInt=this.resources.getIdentifier(idImagetoshowString,"id",packageName)
            image=findViewById(idImagetoshowInt)
            image.alpha=1f
            nametext.text=names[currentImage]
        }
    }
}