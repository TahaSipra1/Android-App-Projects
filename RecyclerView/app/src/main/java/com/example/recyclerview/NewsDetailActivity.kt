package com.example.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val heading=intent.getStringExtra("Heading")
        val imgid=intent.getIntExtra("ImgId",R.drawable.my_pic)
        val newscont=intent.getStringExtra("newsContent")

        val Ivnewimg=findViewById<ImageView>(R.id.newsImg)
        val tvnewsHead=findViewById<TextView>(R.id.newsHeading)
        val tvnewcontent=findViewById<TextView>(R.id.tvnews_content)

        tvnewsHead.text=heading
        tvnewcontent.text=newscont
        Ivnewimg.setImageResource(imgid)

    }
}