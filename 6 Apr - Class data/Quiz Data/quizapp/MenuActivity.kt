package com.bmpl.quizapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    // R is a predefined file

    fun buttonClicked(view : View){
        // send --> id --> quiz screen --> receive --> matching --> c
        //var button = findViewById<Button>(view.id)

        var intent = Intent(this, QuizActivity :: class.java)
        intent.putExtra("selectedId", view.id)  // c -> id
        Log.i("btn id = ", view.id.toString())  // int
        startActivity(intent)

    }
}
