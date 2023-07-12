package com.frisel.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frisel.calculator.ui.theme.LightGray
import com.frisel.calculator.ui.theme.Orange

@Composable
fun Calculator(
    state: CalculatorState,
    bottomSpacing: Dp = 8.dp,
    modifier: Modifier = Modifier,
    onAction: (CalculatorActions) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(bottomSpacing)
        ) {
            Text(
                text = state.num1 + (state.operation?.simbol ?: "") + state.num2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 40.dp),
                fontWeight = FontWeight.Light,
                fontSize = 30.sp,
                maxLines = 3
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
            ) {
                CalculateButton(simbol = "AC",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    })
                CalculateButton(simbol = "DEL",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    })
                CalculateButton(simbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculateOperation.Divide))
                    })
            }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
                ) {
                    CalculateButton(simbol = "7",
                        modifier = Modifier
                            .background(LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorActions.Number(7))
                        })
                    CalculateButton(simbol = "8",
                        modifier = Modifier
                            .background(LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorActions.Number(8))
                        })
                    CalculateButton(simbol = "9",
                        modifier = Modifier
                            .background(LightGray)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorActions.Number(9))
                        })
                    CalculateButton(simbol = "x",
                        modifier = Modifier
                            .background(Orange)
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = {
                            onAction(CalculatorActions.Operation(CalculateOperation.Multypay))
                        })
                }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
            ) {
                CalculateButton(simbol = "4",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    })
                CalculateButton(simbol = "5",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(5))
                    })
                CalculateButton(simbol = "6",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    })
                CalculateButton(simbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculateOperation.Subtract))
                    })
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
            ) {
                CalculateButton(simbol = "1",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    })
                CalculateButton(simbol = "2",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    })
                CalculateButton(simbol = "3",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    })
                CalculateButton(simbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operation(CalculateOperation.Add))
                    })
                        }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(bottomSpacing)
            ) {
                CalculateButton(simbol = "0",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    })
                CalculateButton(simbol = ".",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    })
                CalculateButton(simbol = "=",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    })
            }
                    }
                }
            }