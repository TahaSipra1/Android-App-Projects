package com.example.bottomnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        val bottomview=findViewById<BottomNavigationView>(R.id.bttomNavigation)

        //by default home fragment
        replacewithfragment(Home())

        bottomview.setOnItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> replacewithfragment(Home())
                R.id.item2 ->replacewithfragment(search())
                R.id.item3 ->replacewithfragment(person())
                else -> {
                }
            }
            true
        }
    }

    private fun replacewithfragment(fragment: Fragment) {
        val fragementManager=supportFragmentManager
        val fragementTrasaction=fragementManager.beginTransaction()
        fragementTrasaction.replace(R.id.framLayout,fragment)
        fragementTrasaction.commit()

    }
}