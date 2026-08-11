package com.example.listviewproject2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList: ArrayList<user>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name= arrayOf("Taha","Ronaldo","Tom Holland","Virat","Babar")
        val lastMsg=arrayOf("Hey Wssup","I am fine","good Morning","Awesome","cool")
        val lastMsgTime=arrayOf("3:08 Am","5:00 Pm","7:35 Pm","2:00 Am","9:30 Pm")
        val phoneNo=arrayOf("29816528","148494156","18494916","86468168","18486468")
        val ImageId=intArrayOf(R.drawable.my_pic, R.drawable.ronaldo, R.drawable.tom,R.drawable.virat,R.drawable.babar)
        userArrayList= ArrayList()
        for (eachIndex in name.indices){
            val users= user(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNo[eachIndex], ImageId[eachIndex])
            userArrayList.add(users)

        }
        //Make Aadpter
        val listview=findViewById<ListView>(R.id.Listview)
        listview.isClickable=true

        listview.adapter= MyAdapter(this,userArrayList)

        listview.setOnItemClickListener { parent,view,position,id ->
            //open a new activity
            val username=name[position]
            val userPhoneNo=phoneNo[position]
            val userImgId=ImageId[position]

            val intent= Intent(this, UserActivity::class.java)
            intent.putExtra("name",username)
            intent.putExtra("phone",userPhoneNo)
            intent.putExtra("Img",userImgId)
            startActivity(intent)

        }

    }
}