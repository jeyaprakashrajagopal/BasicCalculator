package com.renraj.basiccalculator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.renraj.basiccalculator.screens.BasicCalculatorScreen
import com.renraj.basiccalculator.screens.BasicCalculatorViewModel

@Composable
fun ColorfulCalculatorNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = BasicCalculatorScreens.Home.route
    ) {
        composable(BasicCalculatorScreens.Home.route) {
            val calculatorViewModel = hiltViewModel<BasicCalculatorViewModel>()
            val calculatorState = calculatorViewModel.result.collectAsState().value
            val derivedResult by remember(calculatorState) {
                derivedStateOf {
                    (calculatorState.firstNumber ?: "") +
                            (calculatorState.operator?.symbol ?: "") +
                            (calculatorState.secondNumber ?: "")
                }
            }
            val onCalculatorAction = remember {
                return@remember calculatorViewModel::onCalculatorAction
            }
            BasicCalculatorScreen(result = derivedResult, onClick = onCalculatorAction)
        }
    }
}