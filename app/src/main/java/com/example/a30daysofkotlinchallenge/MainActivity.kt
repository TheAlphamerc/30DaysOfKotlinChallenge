package com.example.a30daysofkotlinchallenge
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val countUpButton: Button = findViewById(R.id.countUp_Button)
        countUpButton.setOnClickListener { countUp() }

        rollButton.setOnClickListener { rollDice() }
    }
    private fun rollDice(){
        val resultText: TextView = findViewById(R.id.result_text)
        val randomInt = (1..6).random()

        resultText.text = randomInt.toString()
        Toast.makeText(this,"Button clicked,", Toast.LENGTH_SHORT).show()
    }

    private fun countUp(){
        val resultText: TextView = findViewById(R.id.result_text)
        if(resultText.text == "Hello World!"){
            resultText.text = "1"
        }
        else{
            var resultInt = resultText.text.toString().toInt()
            if(resultInt < 6){
                resultInt++
                resultText.text = resultInt.toString()
            }
        }

    }

}
