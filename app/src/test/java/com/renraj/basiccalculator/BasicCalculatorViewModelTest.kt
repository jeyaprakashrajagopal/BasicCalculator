package com.renraj.basiccalculator

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.renraj.basiccalculator.screens.BasicCalculatorViewModel
import com.renraj.basiccalculator.screens.CalculatorState
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BasicCalculatorViewModelTest {
    private lateinit var basicCalculatorViewModel: BasicCalculatorViewModel
    private lateinit var savedStateHandle: SavedStateHandle

    @BeforeEach
    fun setUp() {
        savedStateHandle = SavedStateHandle()
        basicCalculatorViewModel = BasicCalculatorViewModel(savedStateHandle = savedStateHandle)
    }

    @ParameterizedTest
    @CsvSource(
        value = ["2, 1, 3", "3, 5, 8", "5, 8, 13", "5, -10, -5"]
    )
    fun basicAdditionTest(first: String, second: String, expected: String) = runTest {
        savedStateHandle["result"] = CalculatorState(
            firstNumber = first,
            secondNumber = second,
            operator = CalculatorOperation.Add
        )
        basicCalculatorViewModel.onCalculatorAction(calculatorAction = CalculatorAction.Equal)
        basicCalculatorViewModel.result.test {
            assertEquals(expected, awaitItem().firstNumber)
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = ["2, 1, 1", "3, 5, -2", "5, 8, -3", "5, -10, 15"]
    )
    fun basicSubtractTest(first: String, second: String, expected: String) = runTest {
        savedStateHandle["result"] = CalculatorState(
            firstNumber = first,
            secondNumber = second,
            operator = CalculatorOperation.Subtract
        )
        basicCalculatorViewModel.onCalculatorAction(calculatorAction = CalculatorAction.Equal)
        basicCalculatorViewModel.result.test {
            assertEquals(expected, awaitItem().firstNumber)
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = ["2, 1, 2.00", "3, 2, 1.50", "5, 2, 2.50", "10, 10, 1.00"]
    )
    fun basicDivideTest(first: String, second: String, expected: String) = runTest {
        savedStateHandle["result"] = CalculatorState(
            firstNumber = first,
            secondNumber = second,
            operator = CalculatorOperation.Divide
        )
        basicCalculatorViewModel.onCalculatorAction(calculatorAction = CalculatorAction.Equal)
        basicCalculatorViewModel.result.test {
            assertEquals(expected, awaitItem().firstNumber)
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = ["2, 1, 0", "3, 2, 1", "5, 2, 1", "10, 10, 0"]
    )
    fun basicModuloTest(first: String, second: String, expected: String) = runTest {
        savedStateHandle["result"] = CalculatorState(
            firstNumber = first,
            secondNumber = second,
            operator = CalculatorOperation.Modulo
        )
        basicCalculatorViewModel.onCalculatorAction(calculatorAction = CalculatorAction.Equal)
        basicCalculatorViewModel.result.test {
            assertEquals(expected, awaitItem().firstNumber)
        }
    }

    @ParameterizedTest
    @CsvSource(
        value = ["2, 1, 2", "3, 2, 6", "5, 2, 10", "10, 10, 100"]
    )
    fun basicMultiplyTest(first: String, second: String, expected: String) = runTest {
        savedStateHandle["result"] = CalculatorState(
            firstNumber = first,
            secondNumber = second,
            operator = CalculatorOperation.Multiply
        )
        basicCalculatorViewModel.onCalculatorAction(calculatorAction = CalculatorAction.Equal)
        basicCalculatorViewModel.result.test {
            assertEquals(expected, awaitItem().firstNumber)
        }
    }
}