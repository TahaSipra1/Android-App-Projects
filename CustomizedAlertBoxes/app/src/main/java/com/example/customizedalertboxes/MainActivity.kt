package com.example.customizedalertboxes

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mybutton=findViewById<Button>(R.id.btnclick)
        dialog= Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.gb_alert_box))


        //creating a variable for custom_dailogue.xml
        val buttongood = dialog.findViewById<Button>(R.id.btngood)
        val buttonfeedback = dialog.findViewById<Button>(R.id.btnFeedback)

        buttongood.setOnClickListener {
            dialog.dismiss()
        }
        buttonfeedback.setOnClickListener {
            //intent or toast
            //we can do give specific link
            Toast.makeText(this,"Good feedback", Toast.LENGTH_SHORT).show()
        }

        mybutton.setOnClickListener {
            dialog.show()
        }


    }
}