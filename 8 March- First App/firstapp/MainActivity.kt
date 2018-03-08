package com.bmpl.firstapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// : --> inheritance

class MainActivity : AppCompatActivity() {

        // @Override
    // void onCreate(Bundle savedInstanceState){....}
    // fun --> function in kotlin --> use fun keyword
    // ? --> by default nothing is null -->

    // with ? variable can either be null or contains some data --> NPE (Null Pointer Exception)

    // used for initialization --> inside onCreate
    // Bundle is a predefined class in Android which is used to store state of an Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)// parent onCreate functionality is called

        // used to set the front-end view for this Activity
        setContentView(R.layout.activity_main) // int value

        // R --> Predefined class automatically created with every project
        // R holds the reference/id of all the data required in the project

        // Dynamically link front-end widgets with back-end
        // steps :

        // step-1: Downcasting
        // step-2: Attach Listener
        // step-3: Work with Handler

        // var is a keyword --> used for declaring variables

        // step-1: Downcasting

        var name : EditText = findViewById(R.id.nameEditText)
        var password : EditText = findViewById(R.id.passwordEditText)
        var submit : Button = findViewById(R.id.submitButton)
        var clear = findViewById<Button>(R.id.clearButton)
        var result = findViewById<TextView>(R.id.resultTextView)

       // var name  = findViewById<EditText>(R.id.nameEditText)

        // View class --> Button , radiobutton, toggle button, switch, spinner, etc

        // setOnClickListener

        // Listener
        // Button.--> interface --> abstract method

        // lambda function --> kotlin -->
        submit.setOnClickListener {

            // left --> set
            // right --> get
           //welcome ram ram123                 // ram              + ram123
            result.text ="Welcome "  + name.text + " " + password.text

        }
    }
}