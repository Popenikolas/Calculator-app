package com.example.calculator.domain

import org.mariuszgromada.math.mxparser.Expression

/**
 * This class contains the core business logic for the calculator.
 * It is completely independent of the UI.
 */
class Calculator {
    /**
     * Evaluates a mathematical expression string.
     * @param expressionString The mathematical expression to calculate.
     * @return The result as a String, or "Error" if the expression is invalid.
     */
    fun evaluate(expressionString: String): String {
        // Don't attempt to calculate if the input is blank.
        if (expressionString.isBlank()) {
            return ""
        }
        return try {
            // Use the mXparser library to safely evaluate the string.
            val expression = Expression(expressionString)
            val calculatedResult = expression.calculate()

            if (calculatedResult.isNaN()) {
                "Error" // Handle undefined results, like division by zero.
            } else {
                // Return as a whole number (Long) if there's no decimal part.
                if (calculatedResult % 1.0 == 0.0) {
                    calculatedResult.toLong().toString()
                } else {
                    // Otherwise, return the full decimal representation.
                    calculatedResult.toString()
                }
            }
        } catch (e: Exception) {
            "Error" // Handle syntax errors in the expression.
        }
    }
}
