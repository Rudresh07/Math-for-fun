package com.example.mathforfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mathforfun.databinding.ActivityOperatorsBinding

class Operators : AppCompatActivity() {

    private var binding : ActivityOperatorsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOperatorsBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        var operations : String?

        var Standerd = intent.getStringExtra("class")

        if (Standerd == "class1"||Standerd=="class2")
        {
            binding?.division?.visibility = View.GONE
            binding?.multiplication?.visibility = View.GONE
        }
        else
        {
            binding?.division?.visibility = View.VISIBLE
            binding?.multiplication?.visibility = View.VISIBLE
        }

        binding?.addition?.setOnClickListener {

            val intent = Intent(this, Question_Page::class.java)
            intent.putExtra("operations","addition")
            startActivity(intent)

             }

        binding?.subtrsction?.setOnClickListener {

            val intent = Intent(this, Question_Page::class.java)
            intent.putExtra("operations","subtraction")
            startActivity(intent)

        }

        binding?.multiplication?.setOnClickListener {

            val intent = Intent(this, Question_Page::class.java)
            intent.putExtra("operations","multiplication")
            startActivity(intent)

        }

        binding?.division?.setOnClickListener {

            val intent = Intent(this, Question_Page::class.java)
            intent.putExtra("operations","division")
            startActivity(intent)

        }
    }
}