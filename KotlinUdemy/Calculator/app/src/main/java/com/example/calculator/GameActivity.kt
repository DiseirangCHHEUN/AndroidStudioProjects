package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    private var gameBinding: ActivityGameBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        gameBinding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(gameBinding!!.root)
        initListener()
    }

    @SuppressLint("SetTextI18n")
    private fun initListener() {
        gameBinding?.apply {
            var randomNumber = 0
            btnStart.setOnClickListener {
                val isNotEmpty = isNotEmptyInputs()
                if (isNotEmpty) {
                    val random = getRandomNumber(
                        etFirstNum.text.toString().toInt(), etSecondNum.text.toString().toInt()
                    )
//                  Log.i("getRandomNumber", a.toString())
                    inputLayoutGuess.visibility = View.VISIBLE
                    btnGo.visibility = View.VISIBLE
                    randomNumber = random
                }
            }

            btnGo.setOnClickListener {
                cardReport.visibility = View.VISIBLE
                val userGuessNumber = etGuessNumber.text.toString().toInt()
                if (randomNumber == userGuessNumber) {
                    txtReportLabel.text = "Congratulation!\nYou are very clever!"
                } else {
                    txtReportLabel.text = "Opp!!!\nWrong guess."
                }
                btnReport.visibility = View.VISIBLE
            }
        }
    }

    private fun getRandomNumber(first: Int, second: Int): Int {
        var min = first
        var max = second
        if (first > second) {
            max = first
            min = second
        }
        return Random.nextInt(max - min + 1) + min
    }

    private fun isNotEmptyInputs(): Boolean {
        gameBinding?.apply {
            if (TextUtils.isEmpty(etFirstNum.text)) {
                etFirstNum.error = getText(R.string.str_enter_first_input)
            } else if (TextUtils.isEmpty(etSecondNum.text)) {
                etSecondNum.error = getText(R.string.str_enter_second_input)
            }
            return true
        }
        return false
    }
}
