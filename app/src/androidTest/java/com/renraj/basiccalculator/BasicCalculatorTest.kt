package com.renraj.basiccalculator

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class BasicCalculatorTest {
    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun launchBasicAdditionTest() {
        launchBasicCalculatorTest(this.composeRule) {
            performNumberClick(VALID_FIRST_NUMBER)
            performOperatorClick(calculatorOperation = CalculatorOperation.Add)
            performNumberClick(VALID_SECOND_NUMBER)
        } verify {
            checkCalculatorResult("3")
        }
    }

    @Test
    fun launchBasicSubtractTest() {
        launchBasicCalculatorTest(this.composeRule) {
            performNumberClick(VALID_FIRST_NUMBER)
            performOperatorClick(calculatorOperation = CalculatorOperation.Subtract)
            performNumberClick(VALID_SECOND_NUMBER)
        } verify {
            checkCalculatorResult("1")
        }
    }

    @Test
    fun launchBasicMultiplyTest() {
        launchBasicCalculatorTest(this.composeRule) {
            performNumberClick(VALID_FIRST_NUMBER)
            performOperatorClick(calculatorOperation = CalculatorOperation.Multiply)
            performNumberClick(VALID_SECOND_NUMBER)
        } verify {
            checkCalculatorResult("2")
        }
    }

    @Test
    fun launchBasicModuloTest() {
        launchBasicCalculatorTest(this.composeRule) {
            performNumberClick(VALID_FIRST_NUMBER)
            performOperatorClick(calculatorOperation = CalculatorOperation.Modulo)
            performNumberClick(VALID_SECOND_NUMBER)
        } verify {
            checkCalculatorResult("0")
        }
    }

    @Test
    fun launchBasicDivideTest() {
        launchBasicCalculatorTest(this.composeRule) {
            performNumberClick(VALID_FIRST_NUMBER)
            performOperatorClick(calculatorOperation = CalculatorOperation.Modulo)
            performNumberClick(VALID_SECOND_NUMBER)
        } verify {
            checkCalculatorResult("2")
        }
    }

    @Test
    fun testCheckFirstNumberReturnedWhenNoSecondNumber() {
        launchBasicCalculatorTest(this.composeRule) {
            performNumberClick(VALID_FIRST_NUMBER)
            performOperatorClick(calculatorOperation = CalculatorOperation.Modulo)
        } verify {
            checkCalculatorResult(VALID_FIRST_NUMBER)
        }
    }

    @Test
    fun testDotIsIgnoredWhenNoInputAfter() {
        launchBasicCalculatorTest(this.composeRule) {
            performNumberClick(INVALID_FIRST_NUMBER_WITH_DOT)
            performOperatorClick(calculatorOperation = CalculatorOperation.Add)
            performNumberClick(INVALID_SECOND_NUMBER_WITH_DOT)
        } verify {
            checkCalculatorResult("3")
        }
    }

    private companion object {
        const val VALID_FIRST_NUMBER = "2"
        const val INVALID_FIRST_NUMBER_WITH_DOT = "2"
        const val INVALID_SECOND_NUMBER_WITH_DOT = "1"
        const val VALID_SECOND_NUMBER = "1"
    }
}