package com.renraj.basiccalculator.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.renraj.basiccalculator.ui.theme.ColorfulCalculatorTheme

@Composable
fun CalculatorButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .clip(CircleShape)
            .clickable { onClick() },
        shape = CircleShape,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = text,
                style = typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun CalculatorButtonPreview() {
    ColorfulCalculatorTheme {
        Row(Modifier.fillMaxWidth()) {
            CalculatorButton(text = "1", modifier = Modifier.weight(1f))
            CalculatorButton(text = "2", modifier = Modifier.weight(1f))
            CalculatorButton(text = "3", modifier = Modifier.weight(1f))
            CalculatorButton(text = "4", modifier = Modifier.weight(1f))
        }
    }
}