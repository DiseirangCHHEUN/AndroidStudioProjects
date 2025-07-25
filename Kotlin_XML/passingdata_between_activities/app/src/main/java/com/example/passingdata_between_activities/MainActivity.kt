package com.example.passingdata_between_activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.passingdata_between_activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnApply.setOnClickListener{
            val firstname = binding.etFirstname.text.toString()

            Intent(this, SecondActivity::class.java).also {
                it.putExtra("Name", firstname)
                startActivity(it)
            }
        }

    }
}