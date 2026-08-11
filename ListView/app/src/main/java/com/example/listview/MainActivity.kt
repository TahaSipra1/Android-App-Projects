package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listview=findViewById<ListView>(R.id.Listview)
        val TaskList=arrayListOf<String>()
        TaskList.add("Pray 5 times ")
        TaskList.add("Attend Exam")
        TaskList.add("Complete the App dev ")
        TaskList.add("Work on Resume")
        TaskList.add("Learn java")
        val adapterforlistview= ArrayAdapter(this,android.R.layout.simple_list_item_1,TaskList)
        listview.adapter=adapterforlistview
        listview.setOnItemClickListener{parent,view,position,id ->
            val text="Clicked on :"+(view as TextView).text.toString()
            Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
        }
    }
}