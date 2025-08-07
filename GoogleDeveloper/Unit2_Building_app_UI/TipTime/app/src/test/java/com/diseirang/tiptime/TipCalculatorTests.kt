package com.diseirang.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    /*
    * ✅ Summary in Simple Steps

    You give an amount and a tip percentage.

    You know what the correct tip should be.

    You format that expected tip like money ($2.00).

    You run the method and see what it returns.

    You compare your expected result to the actual result.

If they match → Your method is working! 🎉
    * */

    @Test
    fun calculatorTip_20PercentNoRoundup(){
        val amount = 20.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(4)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, roundTip = false)
        assertEquals(expectedTip, actualTip)
    }
}