package com.example.lightsensorapp

import android.content.ContentValues.TAG
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException

class MainActivity : AppCompatActivity() , SensorEventListener{
    companion object {
        private const val TAG = "MainActivity"
    }
    var sensor: Sensor? =null
    var sensorManager: SensorManager?=null
    lateinit var image: ImageView
    lateinit var background: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.background)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        image=findViewById(R.id.diplayImg)
        background=findViewById(R.id.background)
        image.visibility= View.INVISIBLE

        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor=sensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT)
        if (sensor == null) {
            Log.e(TAG, "Light sensor not available on this device")
        }

    }
    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensor?.let {
            sensorManager?.registerListener(
                this,
                it,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        //Most Important Function
        try {
            val lightValue = event?.values?.getOrNull(0) ?: return
            Log.d(TAG, "onSensorChanged: $lightValue")
            if (lightValue < 10){
                //Light is dim
                image.visibility= View.INVISIBLE
                background.setBackgroundColor(resources.getColor(R.color.black))
            }
            else
            {
                //Show torch if lighht intensity is high
                image.visibility= View.VISIBLE
            }

        }catch (e: Exception){
            Log.d(TAG , "onSensorChanged: ${e.message}")
        }
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
}