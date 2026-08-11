package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signbutton=findViewById<Button>(R.id.btsignup)
        val etname=findViewById<TextInputEditText>(R.id.etname)
        val etmail=findViewById<TextInputEditText>(R.id.etmail)
        val username= findViewById<TextInputEditText>(R.id.etuserid)
        val userpass=findViewById<TextInputEditText>(R.id.etpassword)

        signbutton.setOnClickListener {
            val name=etname.text.toString()
            val mail=etmail.text.toString()
            val uniqueid=username.text.toString()
            val password=userpass.text.toString()

            val user= user(name,mail,password,uniqueid)
            etname.text?.clear()
            etmail.text?.clear()
            username.text?.clear()
            userpass.text?.clear()

            database= FirebaseDatabase.getInstance().getReference("users")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registerd",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }
        val signinbutton=findViewById<Button>(R.id.btnsigninmain)
        signinbutton.setOnClickListener {
            val opensigninactivity= Intent(this, signinActivity::class.java)
            startActivity(opensigninactivity)
        }
    }
}