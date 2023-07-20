package com.example.mathforfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mathforfun.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding : ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding?.root

        setContentView(view)


        binding?.class1?.setOnClickListener{
            val intent = Intent(this,Operators::class.java)
            intent.putExtra("class","class1")
            startActivity(intent)
        }

        binding?.class2?.setOnClickListener{
            val intent = Intent(this,Operators::class.java)
            intent.putExtra("class","class2")
            startActivity(intent)
        }

        binding?.class3?.setOnClickListener{
            val intent = Intent(this,Operators::class.java)
            intent.putExtra("class","class3")
            startActivity(intent)
        }

        binding?.class4?.setOnClickListener{
            val intent = Intent(this,Operators::class.java)
            intent.putExtra("class","class4")
            startActivity(intent)
        }
        binding?.class5?.setOnClickListener{
            val intent = Intent(this,Operators::class.java)
            intent.putExtra("class","class5")
            startActivity(intent)
        }

    }
}