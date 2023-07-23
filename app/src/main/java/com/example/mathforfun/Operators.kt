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

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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


        if (Standerd == "class1")
        {

            binding?.addition?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","addition")
                intent.putExtra("class","class1")
                startActivity(intent)

            }

            binding?.subtrsction?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","subtraction")
                intent.putExtra("class","class1")
                startActivity(intent)

            }

        }



        else if (Standerd == "class2")
        {

            binding?.addition?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","addition")
                intent.putExtra("class","class2")
                startActivity(intent)

            }

            binding?.subtrsction?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","subtraction")
                intent.putExtra("class","class2")
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


        else if (Standerd == "class3")
        {

            binding?.addition?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","addition")
                intent.putExtra("class","class3")
                startActivity(intent)

            }

            binding?.subtrsction?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","subtraction")
                intent.putExtra("class","class3")
                startActivity(intent)

            }

            binding?.multiplication?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","multiplication")
                intent.putExtra("class","class3")
                startActivity(intent)

            }

            binding?.division?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","division")
                intent.putExtra("class","class3")
                startActivity(intent)

            }

        }



        else if (Standerd == "class4")
        {

            binding?.addition?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","addition")
                intent.putExtra("class","class4")
                startActivity(intent)

            }

            binding?.subtrsction?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","subtraction")
                intent.putExtra("class","class4")
                startActivity(intent)

            }

            binding?.multiplication?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","multiplication")
                intent.putExtra("class","class4")
                startActivity(intent)

            }

            binding?.division?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","division")
                intent.putExtra("class","class4")
                startActivity(intent)

            }

        }

        else
        {
            binding?.addition?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","addition")
                intent.putExtra("class","class4")
                startActivity(intent)

            }

            binding?.subtrsction?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","subtraction")
                intent.putExtra("class","class4")
                startActivity(intent)

            }

            binding?.multiplication?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","multiplication")
                intent.putExtra("class","class4")
                startActivity(intent)

            }

            binding?.division?.setOnClickListener {

                val intent = Intent(this, Question_Page::class.java)
                intent.putExtra("operations","division")
                intent.putExtra("class","class4")
                startActivity(intent)

            }
        }


    }
}