package com.frisel.calculator

sealed class CalculatorActions{
    data class Number(val number: Int) : CalculatorActions()
    object Clear: CalculatorActions()    // очистить экран
    object Delete: CalculatorActions()   // удаление последнего символа
    object Decimal: CalculatorActions()  // десятичный знак после запятой
    object Calculate: CalculatorActions() // фактическое вычисление
    data class Operation(val operation: CalculateOperation): CalculatorActions()
}
