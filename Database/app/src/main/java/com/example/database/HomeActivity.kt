package com.example.database

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mail=intent.getStringExtra(signinActivity.Key1)
        val name=intent.getStringExtra(signinActivity.Key2)
        val userid=intent.getStringExtra(signinActivity.Key3)

        val welcometext=findViewById<TextView>(R.id.tvwelcome)
        val mailtext=findViewById<TextView>(R.id.tvMail)
        val useridtext=findViewById<TextView>(R.id.tvuniqueid)

        welcometext.text="welcome "+name
        mailtext.text="Mail = "+mail
        useridtext.text="User id  = "+userid
    }
}