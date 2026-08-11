package com.example.alertdialogue

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alertdialogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btn1.setOnClickListener {
            val builder1= AlertDialog.Builder(this)
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to close the app?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes ", DialogInterface.OnClickListener{dialogInterface,i ->
                //what action when yes is clicked
                finish()
            })
            builder1.setNegativeButton("NO ",DialogInterface.OnClickListener{dialogInterface,i ->
                //what action when No is clicked
                dialogInterface.dismiss()
            })
            builder1.show()
        }
        binding.btn2.setOnClickListener {
            val options=arrayOf("Gulab Jamun","Rasmallai","Jalebi")
            val builder2= AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite Sweet")
            builder2.setSingleChoiceItems(options,0, DialogInterface.OnClickListener{dialog ,which ->
                //what action perform when user click on any option
                Toast.makeText(this,"You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Submitted ", DialogInterface.OnClickListener{dialogInterface,i ->
                //what action when yes is clicked
                Toast.makeText(this,"Submitted is done", Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("Decline" +
                    " ",DialogInterface.OnClickListener{dialogInterface,i ->
                //what action when No is clicked
                dialogInterface.dismiss()
            })
            builder2.show()
        }
        binding.btn3.setOnClickListener {
            val options=arrayOf("Gulab Jamun","Rasmallai","Jalebi")
            val builder3= AlertDialog.Builder(this)
            builder3.setTitle("Which is your favourite Sweet")
            builder3.setMultiChoiceItems(options,null, DialogInterface.OnMultiChoiceClickListener{dialog,which,isChecked ->
                Toast.makeText(this,"You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder3.setPositiveButton("Submitted ", DialogInterface.OnClickListener{dialogInterface,i ->
                //what action when yes is clicked
                Toast.makeText(this,"Submitted is done", Toast.LENGTH_SHORT).show()
            })
            builder3.setNegativeButton("Decline" +
                    " ",DialogInterface.OnClickListener{dialogInterface,i ->
                //what action when No is clicked
                dialogInterface.dismiss()
            })
            builder3.show()
        }
    }
}