package com.example.mathforfun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mathforfun.databinding.ActivityQuestionPageBinding
import kotlin.random.Random

class Question_Page : AppCompatActivity() {

    private var binding: ActivityQuestionPageBinding? = null
    private var operators: String? = null
    private var correctAnswer: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuestionPageBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        operators = intent.getStringExtra("operations")

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

        binding?.Next?.setOnClickListener {
            // Check the answer
            val userAnswer = binding?.editText?.text.toString()
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

    private fun generateQuestion() {
        val random = Random.Default
        val min = 1
        val max = 100

        val num1 = random.nextInt(min, max + 1)
        val num2 = random.nextInt(min, num1)

        // Set the operands for the question
        binding?.number1?.text = num1.toString()
        binding?.number2?.text = num2.toString()

        // Calculate the correct answer based on the operator
        correctAnswer = when (operators) {
            "addition" -> num1 + num2
            "subtraction" -> num1 - num2
            "multiplication" -> num1 * num2
            "division" -> num1/num2
        else -> 0// For unsupported operators, set answer to 0 (you can handle this case accordingly)
        }
    }

    private fun checkAnswer(userAnswer: Int): Boolean {
        // Compare the user's answer with the correct answer
        return userAnswer == correctAnswer
    }
}
