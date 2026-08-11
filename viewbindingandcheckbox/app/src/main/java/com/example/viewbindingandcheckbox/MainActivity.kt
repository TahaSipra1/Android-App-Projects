package com.example.viewbindingandcheckbox

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewbindingandcheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Now no need to write findviewbyId etc

        binding.button.setOnClickListener {
            if (binding.checkBox.isChecked){
                intent= Intent(this, MainActivity2::class.java)
                startActivity(intent)

            }
            else
            {
                binding.checkBox.buttonTintList= ColorStateList.valueOf(Color.RED)
                Toast.makeText(this,"Please check terms and condition", Toast.LENGTH_SHORT).show()
            }
        }

    }
}