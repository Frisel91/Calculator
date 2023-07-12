package com.frisel.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import java.nio.file.Files.delete

class CalculateViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set


    fun onAction(actions: CalculatorActions){
            when(actions){
                is CalculatorActions.Number -> enterNumber(actions.number)
                is CalculatorActions.Decimal -> enterDecimal()
                is CalculatorActions.Calculate -> performCalculator()
                is CalculatorActions.Operation -> enterOperation(actions.operation)
                is CalculatorActions.Delete -> performDelete()
                CalculatorActions.Clear -> state = CalculatorState()
            }
    }

    private fun performDelete() {
        when{
            state.num2.isNotBlank() -> state = state.copy(
                num2 = state.num2.dropLast(1)
            )
            state.operation!= null -> state = state.copy(
                operation = null
            )
            state.num1.isNotBlank() -> state = state.copy(
                num1 = state.num1.dropLast(1)
            )
        }
    }

    private fun enterOperation(operation: CalculateOperation) {
        if (state.num1.isNotBlank()){
            state = state.copy(operation = operation)
        }
    }

    private fun performCalculator() {
        val number1 = state.num1.toDoubleOrNull()
        val number2 = state.num2.toDoubleOrNull()
        if (number1!= null && number2!= null){
            val result = when(state.operation){
                is CalculateOperation.Add -> number1 + number2
                is CalculateOperation.Subtract -> number1 - number2
                is CalculateOperation.Divide -> number1 / number2
                is CalculateOperation.Multypay -> number1 * number2
                null -> return
            }
            state = state.copy(
                num1 = result.toString().take(15),
                num2 = "",
                operation = null
            )
        }

    }

    private fun enterDecimal() {
        if (state.operation == null && state.num1.contains(".")
            && state.num1.isNotBlank())
            return
        if (!state.num2.contains(".")
            && state.num2.isNotBlank()){
            state = state.copy(num1 = state.num2 + ".")
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null){
            if (state.num1.length > MAX_NUM_LENGTH){
                return
            }
            state = state.copy(
                num1 = state.num1 + number
            )
            return
        }
            if (state.num2.length > MAX_NUM_LENGTH){
                return
            }
            state = state.copy(
                num2 = state.num2 + number
            )
        }
    companion object {
        private val MAX_NUM_LENGTH = 20
    }
}