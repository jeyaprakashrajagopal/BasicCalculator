package com.renraj.basiccalculator

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class CalculatorAction {
    data class Numbers(val number: String) : CalculatorAction()
    data object Equal : CalculatorAction()
    data object Clear : CalculatorAction()
    data object Decimal: CalculatorAction()
    data class Operator(val calculatorOperation: CalculatorOperation) : CalculatorAction()
}

@Parcelize
sealed class CalculatorOperation(val symbol: String): Parcelable {
    data object Add: CalculatorOperation("+")
    data object Subtract: CalculatorOperation("-")
    data object Modulo: CalculatorOperation("%")
    data object Multiply: CalculatorOperation("*")
    data object Divide: CalculatorOperation("/")
}