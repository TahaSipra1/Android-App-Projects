package com.example.alarmapp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alarmapp.databinding.ActivityMainBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var picker: MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        createNotificationChannel()

        binding.selectedTimebtn.setOnClickListener {
            showTimePicker()
        }

        binding.setALarmbtn.setOnClickListener {
            setAlarm()
        }
        binding.cancelAlarmbtn.setOnClickListener {
            cancelAlarm()
        }


    }

    private fun cancelAlarm() {
        alarmManager=getSystemService(ALARM_SERVICE) as AlarmManager
        val intent= Intent(this, AlarmReceiver::class.java)
        pendingIntent= PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_IMMUTABLE)

        alarmManager.cancel(pendingIntent)
        Toast.makeText(this,"ALarm Cancel Successfuly ", Toast.LENGTH_SHORT).show()
    }

    private fun setAlarm() {
        alarmManager=getSystemService(ALARM_SERVICE) as AlarmManager
        val intent= Intent(this, AlarmReceiver::class.java)
        pendingIntent= PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_IMMUTABLE)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,pendingIntent
        )

        Toast.makeText(this,"ALarm Set Successfuly ", Toast.LENGTH_SHORT).show()
    }

    private fun showTimePicker() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        picker.show(supportFragmentManager,"Sipra")
        picker.addOnPositiveButtonClickListener{
            if(picker.hour>12){
                binding.selectTime.text=
                    String.format("%02d",picker.hour -12)+ " : "+ String.format("%02d", picker.minute)+"PM"
            }
            else{
                binding.selectTime.text =String.format("%02d",picker.hour )+ " : "+ String.format("%02d", picker.minute)+"AM"
            }
            calendar= Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY]=picker.hour
            calendar[Calendar.MINUTE]=picker.minute
            calendar[Calendar.SECOND]=0
            calendar[Calendar.MILLISECOND]=0

        }
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name : CharSequence="TahaSipraRemainderChannel"
            val description="Channel For Alarm Manager"
            val importance= NotificationManager.IMPORTANCE_HIGH
            val channel= NotificationChannel("TahaSipra",name,importance)
            channel.description=description
            val notificationManager=getSystemService(NotificationManager::class.java)

            notificationManager.createNotificationChannel(channel)

        }
    }
}