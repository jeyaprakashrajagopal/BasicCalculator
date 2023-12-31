package com.renraj.basiccalculator

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule

fun launchBasicCalculatorTest(
    composeRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
    block: BasicCalculatorFeature.() -> Unit,
) = BasicCalculatorFeature(composeRule = composeRule).apply(block)

class BasicCalculatorFeature(
    private val composeRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    fun performNumberClick(input: String) {
        composeRule.onNodeWithText(input).performClick()
    }

    fun performOperatorClick(calculatorOperation: CalculatorOperation) {
        composeRule.onNodeWithText(calculatorOperation.symbol).performClick()
    }

    infix fun verify(block: VerifyBasicCalculatorFeature.() -> Unit) =
        VerifyBasicCalculatorFeature(composeRule = composeRule).apply(block)
}

class VerifyBasicCalculatorFeature(
    private val composeRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    fun checkCalculatorResult(result: String) {
        composeRule.onNodeWithText(result).assertIsDisplayed()
    }
}