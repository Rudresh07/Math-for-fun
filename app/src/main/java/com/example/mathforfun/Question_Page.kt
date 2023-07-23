package com.example.mathforfun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.mathforfun.databinding.ActivityQuestionPageBinding
import kotlin.random.Random

class Question_Page : AppCompatActivity() {

    private var binding: ActivityQuestionPageBinding? = null
    private var operators: String? = null
    private var correctAnswer: Int = 0
    private var standerd : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding = ActivityQuestionPageBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        operators = intent.getStringExtra("operations")
        standerd = intent.getStringExtra("class")

        //we are defining the text (symbol as their text so that we can use them for further references

        if (operators == "addition") {
            binding?.symbol?.text = "+"
        } else if (operators == "subtraction") {
            binding?.symbol?.text = "-"
        } else if (operators == "multiplication") {
            binding?.symbol?.text = "x"
        } else if (operators == "division")
        {
            // Display the division symbol (÷)
            binding?.symbol?.text = "\u00F7"
        }


        // Generate the first question
        generateQuestion()

        //to get next question we are using next button how next button works
        binding?.Next?.setOnClickListener {
            // Check if the user's answer is empty
            val userAnswer = binding?.editText?.text.toString().trim()
            if (userAnswer.isEmpty()) {
                Toast.makeText(this, "Please enter your answer", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Return here to prevent generating the next question
            }

            // Check the answer
            if (checkAnswer(userAnswer.toInt())) {
                Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
                generateQuestion()
            } else {
                Toast.makeText(this, "Incorrect Answer", Toast.LENGTH_SHORT).show()
            }
            // Clear the answer input field for the new question
            binding?.editText?.text?.clear()
        }



    }

    private fun generateQuestion(){
        val random=Random.Default

//Define default min and max values for num1 and num2
        var min : Int
        var max :Int

        if(standerd=="class1"){
//If the standard is Class1,limit num1 and num2 between 1and9
            min=1
            max=9
        }
        else if (standerd == "class2")
        {
//For other standards,use the default range(1to100)
            min=1
            max=100
        }

        else if (standerd == "class3")
        {
            if (operators == "addition"||operators=="subtraction")
            {
                min =100
                max = 1000
            }
            else{
                min = 1
                max = 10
            }
        }

        else if (standerd == "class4")
        {
            if (operators == "addition"||operators=="subtraction")
            {
                min =100
                max = 1000
            }
            else{
                min = 10
                max = 100
            }
        }

        else {
            min = 1
            max = 1000
        }

        val number2 = random.nextInt(min, max + 1)


         val num1 = if (standerd=="class3")
        {
            if (operators == "division") {
                // If class 3 and operator is division, generate num1 as a multiple of num2
                val multiple = random.nextInt(1, 10) // Generate a random multiplier (1 to 9)
                // Generate num2 within the specified range
                number2 * multiple // Calculate num1 as a multiple of num2
            } else {
                random.nextInt(number2, max + 1) // Generate num1 within the specified range
            }

        }

        else if (standerd=="class4"){

            if (operators == "division") {
                // If class 3 and operator is division, generate num1 as a multiple of num2
                val multiple = random.nextInt(1, 100) // Generate a random multiplier (1 to 9)
                number2 * multiple // Calculate num1 as a multiple of num2
            } else {
                random.nextInt(number2, max + 1) // Generate num1 within the specified range
            }
        }

        else {
            if (operators == "division") {
                // If class 3 and operator is division, generate num1 as a multiple of num2
                val multiple = random.nextInt(1, 1000) // Generate a random multiplier (1 to 9)
                number2 * multiple // Calculate num1 as a multiple of num2
            } else {
                random.nextInt(number2, max + 1) // Generate num1 within the specified range
            }
        }

        val num2= number2

//Set the operands for the question
        binding?.number1?.text=num1.toString()
        binding?.number2?.text=num2.toString()

//Calculate the correct answer based on the operator
        correctAnswer=when(operators){
            "addition"->num1+num2
            "subtraction"->num1-num2
            "multiplication"->num1*num2
            "division"->num1/num2
            else->0//For unsupported operators,set answer to 0(you can handle this case accordingly)
        }
    }

    private fun checkAnswer(userAnswer: Int): Boolean {
        // Compare the user's answer with the correct answer
        return userAnswer == correctAnswer
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
