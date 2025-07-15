package com.example.calculator
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding!!.root)

        mainBinding?.apply {

            fun hideKeyboard() {
                (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
                    .hideSoftInputFromWindow(
                        mainBinding?.root?.windowToken,
                        0
                    )
            }

            fun operation(operate: Char) {

                val firstNum = etFirstNum.text.toString().toFloat()
                val secondNum = etSecondNum.text.toString().toFloat()

                if (TextUtils.isEmpty(etFirstNum.text)) {
                    etFirstNum.error = getText(R.string.str_enter_first_input)
                    return
                }

                if (TextUtils.isEmpty(etSecondNum.text)) {
                    etSecondNum.error = getText(R.string.str_enter_second_input)
                    return
                }

                val result = when (operate) {
                    '+' -> firstNum + secondNum
                    '-' -> firstNum - secondNum
                    '*' -> firstNum * secondNum
                    '/' -> firstNum / secondNum
                    else -> 0
                }.toString()

                txtResult.text = result
            }
            btnAdd.setOnClickListener {
                hideKeyboard()
                operation('+')
            }
            btnMinus.setOnClickListener {
                hideKeyboard()
                operation('-')
            }
            btnMulti.setOnClickListener {
                hideKeyboard()
                operation('*')
            }
            btnDivide.setOnClickListener {
                hideKeyboard()
                operation('/')
            }

            btnGame.setOnClickListener {
                 startActivity(Intent(applicationContext, GameActivity::class.java))
            }
        }

        // also can use like below
//        mainBinding.btnAdd.setOnClickListener {
//            operation('+')
//        }
//        mainBinding.btnMinus.setOnClickListener {
//            operation('-')
//        }
//
//        mainBinding.btnMulti.setOnClickListener {
//            operation('*')
//        }
//
//        mainBinding.btnDivide.setOnClickListener {
//            operation('/')
//        }
    }

//    fun operation (operate : Char){
//        var firstNum = findViewById<EditText>(R.id.etFirstNum)
//        var secondNum = findViewById<EditText>(R.id.etSecondNum)
//        var resultText = findViewById<TextView>(R.id.txtResult)
//
//        if(TextUtils.isEmpty(firstNum.text)){
//            firstNum.error= getText(R.string.str_enter_first_input)
//            return
//        }
//
//        if(TextUtils.isEmpty(secondNum.text)){
//            secondNum.error= getText(R.string.str_enter_second_input)
//            return
//        }
//
//        val result = when(operate){
//            '+' -> firstNum.text.toString().toInt() + secondNum.text.toString().toInt()
//            '-'-> firstNum.text.toString().toInt() - secondNum.text.toString().toInt()
//            '*' -> firstNum.text.toString().toInt() * secondNum.text.toString().toInt()
//            '/' -> firstNum.text.toString().toInt() / secondNum.text.toString().toInt()
//            else -> 0
//        }
//
//        resultText.text = result.toString()
//    }

//    fun btnAddClicked(view: View) {
//        operation('+')
//    }
//
//    fun btnMinusClicked(view: View) {
//        operation('-')
//    }
//
//    fun btnMultiplyClicked(view: View) {
//        operation('*')
//    }
//
//    fun btnDivideClicked(view: View) {
//        operation('/')
//    }

}