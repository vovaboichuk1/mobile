package com.cricoo.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var displayTextView: TextView

    private var firstOperand = ""
    private var secondOperand = ""
    private var currentOperator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        displayTextView = findViewById(R.id.displayTextView)
    }

    fun onDigitClick(view: View) {
        val digit = (view as Button).text.toString()
        if (currentOperator.isEmpty()) {
            firstOperand += digit
            updateDisplay(firstOperand)
        } else {
            secondOperand += digit
            updateDisplay(secondOperand)
        }
    }

    fun onOperatorClick(view: View) {
        currentOperator = (view as Button).text.toString()
        if (firstOperand.isNotEmpty() && secondOperand.isNotEmpty()) {
            performCalculation()
        }
    }


    fun onEqualsClick(view: View) {
        if (firstOperand.isNotEmpty() && secondOperand.isNotEmpty()) {
            performCalculation()
        }
    }


    fun onClearClick(view: View) {
        firstOperand = ""
        secondOperand = ""
        currentOperator = ""
        updateDisplay("0")
    }

    private fun performCalculation() {
        val result = when (currentOperator) {
            "+" -> firstOperand.toDouble() + secondOperand.toDouble()
            "-" -> firstOperand.toDouble() - secondOperand.toDouble()
            "*" -> firstOperand.toDouble() * secondOperand.toDouble()
            "/" -> {
                if (secondOperand.toDouble() != 0.0) {
                    firstOperand.toDouble() / secondOperand.toDouble()
                } else {
                    // Повідомлення про помилку при діленні на нуль
                    // Повернення нуля у випадку ділення на нуль
                    return
                }
            }
            else -> 0.0
        }

        firstOperand = result.toString() // Оновлення значення firstOperand
        updateDisplay(firstOperand.toDouble()) // Оновлення відображення з новим результатом
        secondOperand = ""
        currentOperator = ""
    }


    private fun updateDisplay(value: Any) {
        displayTextView.text = value.toString()
    }
}



