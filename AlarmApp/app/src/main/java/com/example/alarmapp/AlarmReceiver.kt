package com.example.alarmapp

import android.Manifest
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver: BroadcastReceiver() {
    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun onReceive(context: Context?, intent: Intent?) {
        val i= Intent(context, DestinationActivity ::class.java)
        i.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent= PendingIntent.getActivity(context,0,i, PendingIntent.FLAG_IMMUTABLE)
        val builder= NotificationCompat.Builder(context!!,"TahaSipra")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Sipra Alarm Manager")
            .setContentText("I hope you like the project")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
        val notificationManager= NotificationManagerCompat.from(context)
        notificationManager.notify(123,builder.build())

    }
}