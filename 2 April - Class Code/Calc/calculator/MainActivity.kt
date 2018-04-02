package com.vinti.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //var name : String = "Ram"

    var first = 0
    var second = 0
    var operation = ""  // -
    var operatorSet = false
    var delete = 1

    override fun onClick(v: View?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        buttonClear.setOnClickListener {
            // clear all data from screen
        }

    }

    fun buttonClicked(view:View){
        operatorSet = false
        var button = findViewById<Button>(view.id)

        inputTextView.text = inputTextView.text.toString() + button.text // 8

        if(operation.isNotEmpty()){   // 78+56+54-87+43 -->   -->
            second = inputTextView.text.toString().substringAfterLast(operation).toInt()

            resultTextView.text = when(operation){
                "+"-> (first+second).toString()
                "-"-> (first-second).toString()
                "X"-> (first*second).toString()
                "/"-> (first/second).toString()
                else->""
            }
            first = resultTextView.text.toString().toInt()
            //operation = ""
        }

    }

    fun operationRequested(view:View){
//25+56+
        if(operation.isEmpty())
            first = inputTextView.text.toString().toInt()   // Long.parseInt(String value)

        var button : Button = findViewById(view.id)

        operation = button.text.toString()  // -

        if(!operatorSet) {  //25-
            inputTextView.text = inputTextView.text.toString() + button.text
            operatorSet = true
        }else                   //58 dropLast(1)
            inputTextView.text = inputTextView.text.toString().dropLast(delete) + button.text
            // classname, methodname, variable,
         Log.d("text view value","" + inputTextView.text)
    }
}

