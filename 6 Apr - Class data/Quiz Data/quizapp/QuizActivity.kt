package com.bmpl.quizapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    // late initialization
    lateinit var questionsArray : Array<String>
    lateinit var optionsArray : Array<String>
    lateinit var answersArray : Array<String>

    var counter = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var intent = intent // getIntent
        var id : Int = intent.getIntExtra("selectedId", 0)

        when(id){
            R.id.buttonc-> {
                questionsArray = resources.getStringArray(R.array.cQuestions)
                optionsArray = resources.getStringArray(R.array.cOptions)
                answersArray = resources.getStringArray(R.array.cAnswers)
            }
            R.id.buttonJava-> Log.i("Fetched id", "Java id is fetched")
            R.id.buttonDotNet-> Log.i("Fetched id", "Dotnet id is fetched")
            R.id.buttonAndroid-> Log.i("Fetched id", "C id is fetched")
        }

        changeQuestions()

        nextButton.setOnClickListener {

            counter++
            checkScore()
            radioGroup.clearCheck()
            if(counter<questionsArray.size)
                changeQuestions()
            else{
                var intent = Intent()
                // put score in intent object
                //startActivity(intent)
            }

        }

    }

    fun changeQuestions(){
        questionTextView.text = questionsArray[counter]     // counter = 2
        radioButton1.text = optionsArray[counter * 4]      // 2*4  = 8
        radioButton2.text = optionsArray[counter * 4 + 1]  // 4 + 1 = 5
        radioButton3.text = optionsArray[counter * 4 + 2] // 4 + 2 = 6
        radioButton4.text = optionsArray[counter * 4 + 3] // 4 + 3 = 7
    }

    fun checkScore(){

       var radioButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
        if (radioButton.text.equals(answersArray[counter]))
            score++
    }
}
