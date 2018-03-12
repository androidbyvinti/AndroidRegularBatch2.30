package com.bmpl.workingwithimages

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageOneButton.setOnClickListener {
            imageView.setImageResource(R.drawable.image2)
        }
        imageTwoButton.setOnClickListener {
            imageView.setImageResource(R.drawable.image3)
        }

    }
}
