package com.renraj.basiccalculator.screens

import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.renraj.basiccalculator.CalculatorAction
import com.renraj.basiccalculator.CalculatorOperation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.parcelize.Parcelize
import java.math.RoundingMode
import javax.inject.Inject

@HiltViewModel
class BasicCalculatorViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _result = savedStateHandle.getStateFlow(RESULT, CalculatorState())
    val result: StateFlow<CalculatorState> = _result

    fun onCalculatorAction(calculatorAction: CalculatorAction) {
        when (calculatorAction) {
            CalculatorAction.Clear -> savedStateHandle[RESULT] = CalculatorState()
            CalculatorAction.Equal -> onEqualClicked()
            CalculatorAction.Decimal -> onDotClicked()
            is CalculatorAction.Numbers -> onNumberClicked(calculatorAction.number)
            is CalculatorAction.Operator -> onOperatorClicked(calculatorAction.calculatorOperation)
        }
    }

    private fun onDotClicked() {
        val calculatorResult = _result.value
        when {
            calculatorResult.secondNumber != null && calculatorResult.secondNumber.contains(".") -> return
            calculatorResult.secondNumber != null -> savedStateHandle[RESULT] =
                calculatorResult.copy(secondNumber = calculatorResult.secondNumber + ".")

            calculatorResult.firstNumber != null && calculatorResult.firstNumber.contains(".") -> return
            calculatorResult.firstNumber != null -> savedStateHandle[RESULT] =
                calculatorResult.copy(firstNumber = calculatorResult.firstNumber + ".")
        }
    }

    private fun onOperatorClicked(calculatorOperation: CalculatorOperation) {
        val calculatorResult = _result.value
        when {
            calculatorResult.firstNumber == null || calculatorResult.firstNumber.endsWith(".") -> return
            calculatorResult.secondNumber != null -> return
            else -> savedStateHandle[RESULT] = calculatorResult.copy(operator = calculatorOperation)
        }
    }

    private fun onNumberClicked(number: String) {
        val calculatorResult = _result.value
        when {
            calculatorResult.secondNumber != null -> savedStateHandle[RESULT] =
                calculatorResult.copy(secondNumber = calculatorResult.secondNumber + number)

            calculatorResult.operator == null -> savedStateHandle[RESULT] =
                calculatorResult.copy(firstNumber = (calculatorResult.firstNumber ?: "") + number)

            else -> savedStateHandle[RESULT] =
                calculatorResult.copy(secondNumber = (calculatorResult.secondNumber ?: "") + number)
        }
    }

    private fun onEqualClicked() {
        val result = _result.value

        when {
            result.firstNumber != null && result.operator != null && result.secondNumber != null ->
                onValidData(result)

            result.operator != null && result.secondNumber == null ->
                savedStateHandle[RESULT] = result.copy(firstNumber = result.firstNumber)

            else -> return
        }
    }

    private fun onValidData(result: CalculatorState) {
        if (result.firstNumber == null || result.secondNumber == null || result.operator == null) return
        val firstNumber = result.firstNumber.toBigDecimal()
        val secondNumber =
            if (result.secondNumber.endsWith(".")) result.secondNumber.dropLast(1)
                .toBigDecimal() else result.secondNumber.toBigDecimal()
        savedStateHandle[RESULT] = try {
            CalculatorState(
                firstNumber = when (result.operator) {
                    CalculatorOperation.Add -> firstNumber + secondNumber
                    CalculatorOperation.Divide -> firstNumber.divide(secondNumber, 2, RoundingMode.HALF_UP)
                    CalculatorOperation.Modulo -> firstNumber % secondNumber
                    CalculatorOperation.Multiply -> firstNumber * secondNumber
                    CalculatorOperation.Subtract -> firstNumber - secondNumber
                }.toString()
            )
        } catch (_: ArithmeticException) {
            Log.d("Exception", "Invalid data!")
            CalculatorState()
        }
    }

    private companion object {
        const val RESULT = "result"
    }
}

@Parcelize
data class CalculatorState(
    val firstNumber: String? = null,
    val operator: CalculatorOperation? = null,
    val secondNumber: String? = null,
) : Parcelable