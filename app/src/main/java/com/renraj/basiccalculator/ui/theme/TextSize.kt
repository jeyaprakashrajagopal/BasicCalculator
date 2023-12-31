package com.renraj.basiccalculator.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class TextSize(
    val default: TextUnit = 0.sp,
    val extraSmall: TextUnit = 8.sp,
    val small: TextUnit = 12.sp,
    val medium: TextUnit = 14.sp,
    val normal: TextUnit = 16.sp,
    val large: TextUnit = 18.sp,
    val veryLarge: TextUnit = 24.sp,
    val extraLarge: TextUnit = 40.sp,
)

val LOCAL_TEXT_SIZE = staticCompositionLocalOf { TextSize() }

val MaterialTheme.textSize
    @Composable
    @ReadOnlyComposable
    get() = LOCAL_TEXT_SIZE.current