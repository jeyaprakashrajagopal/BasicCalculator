package com.renraj.basiccalculator.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.renraj.basiccalculator.CalculatorAction
import com.renraj.basiccalculator.CalculatorOperation
import com.renraj.basiccalculator.components.CalculatorButton
import com.renraj.basiccalculator.ui.theme.dimensions
import com.renraj.basiccalculator.ui.theme.textSize

@Composable
fun BasicCalculatorScreen(
    result: String,
    modifier: Modifier = Modifier,
    onClick: (CalculatorAction) -> Unit
) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.dimen1)) {
        CalculatorTextView(
            text = result,
            modifier = Modifier
                .weight(1f)
        )
        CalculatorOperationView(
            modifier = Modifier
                .weight(2f)
                .padding(MaterialTheme.dimensions.dimen2),
            onClick = onClick
        )
    }
}

@Composable
fun CalculatorTextView(text: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(MaterialTheme.dimensions.dimen2),
        contentAlignment = Alignment.BottomEnd
    ) {
        Text(
            text = text,
            fontSize = MaterialTheme.textSize.extraLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = MaterialTheme.dimensions.dimen1),
            maxLines = 5,
            textAlign = TextAlign.End,
            lineHeight = MaterialTheme.textSize.extraLarge,
        )
    }
}

@Composable
fun CalculatorOperationView(modifier: Modifier = Modifier, onClick: (CalculatorAction) -> Unit) {
    Column(modifier) {
        FirstRow(modifier = Modifier.weight(1f), onClick)
        SecondRow(modifier = Modifier.weight(1f), onClick)
        ThirdRow(modifier = Modifier.weight(1f), onClick)
        FourthRow(modifier = Modifier.weight(1f), onClick)
        FifthRow(modifier = Modifier.weight(1f), onClick)
    }
}

@Composable
fun FirstRow(modifier: Modifier, onClick: (CalculatorAction) -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.dimen1)
    ) {
        CalculatorButton(
            text = "AC",
            modifier = Modifier
                .wrapContentHeight()
                .weight(2f)
                .aspectRatio(2f),
            onClick = { onClick(CalculatorAction.Clear) }
        )
        CalculatorButton(
            text = "%",
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Operator(CalculatorOperation.Modulo)) })
        CalculatorButton(
            text = "/",
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Operator(CalculatorOperation.Divide)) })
    }
}

@Composable
fun SecondRow(modifier: Modifier, onClick: (CalculatorAction) -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.dimen1)
    ) {
        CalculatorButton(
            text = "7",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("7")) }
        )
        CalculatorButton(
            text = "8",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("8")) })
        CalculatorButton(
            text = "9",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("9")) })
        CalculatorButton(
            text = CalculatorOperation.Multiply.symbol,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Operator(CalculatorOperation.Multiply)) })
    }
}

@Composable
fun ThirdRow(modifier: Modifier, onClick: (CalculatorAction) -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.dimen1)
    ) {
        CalculatorButton(
            text = "4",
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("4")) }
        )
        CalculatorButton(
            text = "5",
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("5")) })
        CalculatorButton(
            text = "6",
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("6")) })
        CalculatorButton(
            text = CalculatorOperation.Subtract.symbol,
            modifier = Modifier
                .wrapContentHeight()
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Operator(CalculatorOperation.Subtract)) })
    }
}

@Composable
fun FourthRow(modifier: Modifier, onClick: (CalculatorAction) -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.dimen1)
    ) {
        CalculatorButton(
            text = "1",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("1")) }
        )
        CalculatorButton(
            text = "2",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("2")) })
        CalculatorButton(
            text = "3",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Numbers("3")) })
        CalculatorButton(
            text = CalculatorOperation.Add.symbol,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Operator(CalculatorOperation.Add)) })
    }
}

@Composable
fun FifthRow(modifier: Modifier, onClick: (CalculatorAction) -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.dimen1)
    ) {
        CalculatorButton(
            text = "0",
            modifier = Modifier
                .weight(2f)
                .aspectRatio(2f),
            onClick = { onClick(CalculatorAction.Numbers("0")) }
        )
        CalculatorButton(
            text = ".",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Decimal) })
        CalculatorButton(
            text = "=",
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f),
            onClick = { onClick(CalculatorAction.Equal) })
    }
}

@Preview
@Composable
fun BasicCalculatorScreenPreview() {
    BasicCalculatorScreen(result = "test", modifier = Modifier.fillMaxSize(), {})
}