package com.frisel.calculator

sealed class CalculateOperation(val simbol: String){
    object Add: CalculateOperation("+")
    object Subtract: CalculateOperation("-")
    object Multypay: CalculateOperation("*")
    object Divide: CalculateOperation("/")
}
