package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signinActivity : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference
    companion object{
        const val Key1="com.example.database.signinActivity.mail"
        const val Key2="com.example.database.signinActivity.name"
        const val Key3="com.example.database.signinActivity.id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signInButton=findViewById<Button>(R.id.btnsignin)
        val usernamesignin=findViewById<TextInputEditText>(R.id.etusernameet)

        signInButton.setOnClickListener {
            val userNameString=usernamesignin.text.toString()
            if(userNameString.isNotEmpty()){
                readdata(userNameString)
            }
            else{
                Toast.makeText(this,"Please Enter username ", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun readdata(userNameString: String) {
        databaseReference= FirebaseDatabase.getInstance().getReference("users")
        databaseReference.child(userNameString).get().addOnSuccessListener{
            if(it.exists()){
                // welcome in app
                val email=it.child("email").value
                val name=it.child("name").value
                //Password is not getting for safety
                val userId=it.child("uniqueid").value

                val intentwelcome= Intent(this, HomeActivity::class.java)
                intentwelcome.putExtra(Key1,email.toString())
                intentwelcome.putExtra(Key2,name.toString())
                intentwelcome.putExtra(Key3,userId.toString())
                startActivity(intentwelcome)
            }
            else{
                Toast.makeText(this,"User not exit ",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this,"failed ",Toast.LENGTH_SHORT).show()
        }
    }

}