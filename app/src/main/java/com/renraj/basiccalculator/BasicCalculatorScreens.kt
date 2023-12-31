package com.renraj.basiccalculator

sealed class BasicCalculatorScreens(val route: String) {
    data object Home: BasicCalculatorScreens("Home")
}