package com.example.calculator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.calculator.domain.Calculator

/**
 * The ViewModel acts as the bridge between the UI (View) and the business logic (Domain).
 * It holds the UI state and handles user actions.
 */
class CalculatorViewModel {

    // An instance of our domain logic class.
    private val calculator = Calculator()

    // UI state for the input expression. It's exposed to the UI.
    var input by mutableStateOf("")
        private set // `private set` means only the ViewModel can modify this state.

    // UI state for the result.
    var result by mutableStateOf("")
        private set

    /**
     * This is the single entry point for all user actions from the UI.
     * It delegates the action to the appropriate private function.
     */
    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> clear()
            is CalculatorAction.Backspace -> backspace()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun enterNumber(number: String) {
        // If a result is already shown, start a new calculation.
        if (result.isNotEmpty()) {
            input = ""
            result = ""
        }
        input += number
    }

    private fun enterOperation(operation: String) {
        if (input.isNotBlank()) {
            input += operation
        }
    }

    private fun enterDecimal() {
        // Prevent adding multiple decimal points.
        if (input.isNotBlank() && !input.contains(".")) {
            input += "."
        }
    }

    private fun clear() {
        input = ""
        result = ""
    }

    private fun backspace() {
        if (input.isNotEmpty()) {
            input = input.dropLast(1)
        }
    }

    private fun calculate() {
        // Use the domain class to perform the calculation.
        result = calculator.evaluate(input)
    }
}

/**
 * A sealed class represents a restricted set of types.
 * This makes the code more robust and readable by defining all possible user actions.
 */
sealed class CalculatorAction {
    data class Number(val number: String) : CalculatorAction()
    data class Operation(val operation: String) : CalculatorAction()
    object Decimal : CalculatorAction()
    object Clear : CalculatorAction()
    object Backspace : CalculatorAction()
    object Calculate : CalculatorAction()
}