package com.example.edwincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var limit = 50
        var emilyModes = false
        val random = Random()
        var randomNumber1 = random.nextInt(limit)
        var randomNumber2 = random.nextInt(limit)

        showQuestionsBtn.setOnClickListener(){
            randomNumber1 = random.nextInt(limit)
            randomNumber2 = random.nextInt(limit)
            questionField1.text = randomNumber1.toString()
            questionField3.text = randomNumber2.toString()
            resultField.text.clear()
            resultOfResult.text = ""
        }

        emilyBtn.setOnClickListener(){
            if(emilyModes) {
                limit = 50
                emilyModes = false
                emilyBtn.setBackgroundColor(0xFFFF0000.toInt())
            } else{
                limit = 5
                emilyModes = true
                emilyBtn.setBackgroundColor(0xFF00FF00.toInt())
            }
        }

        fertigBtn.setOnClickListener(){
            val result = resultField.text.toString().toIntOrNull()
            if(result != null && (randomNumber1 + randomNumber2 == result)) {
                resultOfResult.text = "OK"
            } else {
                resultOfResult.text = "Nicht OK"
            }
        }
    }
}