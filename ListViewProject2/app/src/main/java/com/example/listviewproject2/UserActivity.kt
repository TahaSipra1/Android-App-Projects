package com.example.listviewproject2

import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name=intent.getStringExtra("name")
        val phoneNumber=intent.getStringExtra("phone")
        val ImgId =intent.getIntExtra("Img",R.drawable.my_pic)

        val tvName=findViewById<TextView>(R.id.tvName)
        val tvPhone=findViewById<TextView>(R.id.tvphone)
        val imageId=findViewById<CircleImageView>(R.id.profile_image1)

        tvName.text=name
        tvPhone.text=phoneNumber
        imageId.setImageResource(ImgId)

    }
}