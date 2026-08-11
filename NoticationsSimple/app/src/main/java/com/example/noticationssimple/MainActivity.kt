package com.example.noticationssimple

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.Manifest
import android.app.PendingIntent
import android.content.Intent

class MainActivity : AppCompatActivity() {
    val ChannelId="channelid"
    val ChannelName="channelname"
    val noticationId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        createNotificationChannel() //notification permission

        //pending Intent
        val intent= Intent(this, MainActivity::class.java)
        val pendingintent= PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_MUTABLE)

        //For getting permisson after android 13 and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )

        }

        val notification= NotificationCompat.Builder(this,ChannelId)
            .setContentTitle("30 days of app dev")
            .setContentText("Congratulation for showing up today")
            .setSmallIcon(R.drawable.outline_add_reaction_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingintent)
            .build()

        val noticationManager= NotificationManagerCompat.from(this)
        val btn=findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this,Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                return@setOnClickListener            }
            noticationManager.notify(noticationId,notification)
        }
    }

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel= NotificationChannel(ChannelId,ChannelName, NotificationManager.IMPORTANCE_DEFAULT).apply {
                //any action you want to perform
                description="this is my notication Channel"
                lightColor= Color.GREEN
                enableLights(true)
            }
            val manager=getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}