package com.muhammetgundogar.kotlinchronometerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pauseOffset:Long=0
        var isCount=false
        Toast.makeText(applicationContext,"Tap To Image To Get Started Chronometer",
        Toast.LENGTH_LONG).show()


        imageView.setOnClickListener {
            if (!isCount){
                chronoMeter.base=SystemClock.elapsedRealtime()-pauseOffset
                chronoMeter.start()
                isCount=true
            } else {
                chronoMeter.stop()
                pauseOffset= (SystemClock.elapsedRealtime()-chronoMeter.base).toLong()

                isCount=false

            }


            Toast.makeText(applicationContext,getString(
                if(isCount)
                    R.string.working
            else
                    R.string.stopped),
                Toast.LENGTH_LONG).show()





        }

        buttonZero.setOnClickListener {
            chronoMeter.base=SystemClock.elapsedRealtime()
            pauseOffset=0

        }

    }
}