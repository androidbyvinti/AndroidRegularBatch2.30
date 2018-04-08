package com.bmpl.quizapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity

// 3 thread --> MainThread -> Runnable + UI Thread
// MainThread
class SplashActivity : AppCompatActivity() {

    val DELAY_MILLISECONS = 3000L   // l --> long or L --> Long

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Handler class --> postDelayed(Runnable runnable, long delayMilliseconds)

            var handler = Handler()
            //handler =  Handler()

        // onClick(){ .... }

            // Thread
            var run = Runnable {
                // void run(){
                var intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)

                finish()
            //}
            }

            handler.postDelayed(run, DELAY_MILLISECONS)

    }
}
