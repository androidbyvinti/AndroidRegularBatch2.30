package com.bmpl.switchingactivities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)


        submitButton.setOnClickListener {
                                // source           // Destination --> java class --> Intent
            var intent = Intent(this, SecondActivity :: class.java)   //
                // SecondActivity.class
            // startActivity(Intent obj)

            startActivity(intent)// switch to the destination --> intent
        }

    }
}
