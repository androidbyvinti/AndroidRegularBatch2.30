package com.vinti.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //var name : String = "Ram"

    var first = 0

    var operation = ""

    override fun onClick(v: View?) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    // view class
    fun buttonClicked(view:View){
        // 8
        //var button : Button = view.id.toString()

        var button = findViewById<Button>(view.id)
        // "" + 7 = 7 + 8 -> 78
        inputTextView.text = inputTextView.text.toString() + button.text // 8

    }

    // 77 + 6575


    // 77  --> In
    fun operationRequested(view:View){
        // 77+54 --> NumberFormatException
        first = inputTextView.text.toString().toInt()   // Long.parseInt(String value)

        var button : Button = findViewById(view.id)

        operation = button.text.toString()  // -

        inputTextView.text = inputTextView.text.toString() + button.text
    }

}