package com.example.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myrecyclerview: RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        myrecyclerview=findViewById(R.id.recyclerview)

        val newsImgArray=arrayOf(R.drawable.my_pic,R.drawable.ronaldo,
            R.drawable.tom,R.drawable.babar,R.drawable.virat)

        val newsHeadingArray=arrayOf("Upcomming App developer and Ai Engineer",
            "Ronaldo’s Record-Breaking Journey in Football",
            "The Face of Marvel’s Friendly Neighborhood Hero",
            "Consistency Personified: Babar’s Batting Masterclass",
            "Virat Kohli: The King of Modern Cricket")

        val newscontent=arrayOf(getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content))

        myrecyclerview.layoutManager= LinearLayoutManager(this)

        newsArrayList= arrayListOf<News>()

        for(everyindex in newsImgArray.indices){
            val news=News(newsHeadingArray[everyindex],newsImgArray[everyindex],newscontent[everyindex])
            newsArrayList.add(news)
        }
        var Myadapter=Myadapter(newsArrayList,this)
        myrecyclerview.adapter=Myadapter
        Myadapter.setIItemClickListener(object : Myadapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                //onclicking item what action do you want to perform
                val intent= Intent(this@MainActivity, NewsDetailActivity::class.java)

                intent.putExtra("Heading",newsArrayList[position].newsHeading)
                intent.putExtra("ImgId",newsArrayList[position].newsImage)
                intent.putExtra("newsContent",newsArrayList[position].news_content)
                startActivity(intent)

            }

        })
    }
}