package com.example.passingdata_between_activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.passingdata_between_activities.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstname = intent.getStringExtra("Name")

        binding.txtShow.text = firstname
    }
}
