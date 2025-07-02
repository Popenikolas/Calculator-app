
package com.example.calculator.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.*
import com.example.calculator.ui.view.components.CalculatorButton
import com.example.calculator.viewmodel.CalculatorAction
import com.example.calculator.viewmodel.CalculatorViewModel

/**
 * This is the main UI Composable for the calculator.
 * It is "state-less" in that it just observes state from the ViewModel
 * and sends actions to it.
 */
@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = CalculatorViewModel()) {
    // Observe the state from the ViewModel. Compose will automatically
    // recompose this screen whenever these values change.
    val input = viewModel.input
    val result = viewModel.result

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGray),
        verticalArrangement = Arrangement.Bottom
    ) {
        // Display Area
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = input,
                color = White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.End,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = result,
                color = Color.Gray,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                maxLines = 1
            )
        }

        // Button Grid Area
        Column(modifier = Modifier.padding(8.dp)) {
            // Each button click sends a specific action to the ViewModel.
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("C", textColor = Black, backgroundColor = LightGray) { viewModel.onAction(CalculatorAction.Clear) }
                CalculatorButton("⌫", textColor = Black, backgroundColor = LightGray) { viewModel.onAction(CalculatorAction.Backspace) }
                CalculatorButton("%", textColor = Black, backgroundColor = LightGray) { viewModel.onAction(CalculatorAction.Operation("%")) }
                CalculatorButton("÷", backgroundColor = Orange) { viewModel.onAction(CalculatorAction.Operation("/")) }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("7") { viewModel.onAction(CalculatorAction.Number("7")) }
                CalculatorButton("8") { viewModel.onAction(CalculatorAction.Number("8")) }
                CalculatorButton("9") { viewModel.onAction(CalculatorAction.Number("9")) }
                CalculatorButton("×", backgroundColor = Orange) { viewModel.onAction(CalculatorAction.Operation("*")) }
            }
             Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("4") { viewModel.onAction(CalculatorAction.Number("4")) }
                CalculatorButton("5") { viewModel.onAction(CalculatorAction.Number("5")) }
                CalculatorButton("6") { viewModel.onAction(CalculatorAction.Number("6")) }
                CalculatorButton("−", backgroundColor = Orange) { viewModel.onAction(CalculatorAction.Operation("-")) }
            }
             Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("1") { viewModel.onAction(CalculatorAction.Number("1")) }
                CalculatorButton("2") { viewModel.onAction(CalculatorAction.Number("2")) }
                CalculatorButton("3") { viewModel.onAction(CalculatorAction.Number("3")) }
                CalculatorButton("+", backgroundColor = Orange) { viewModel.onAction(CalculatorAction.Operation("+")) }
            }
             Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                CalculatorButton("0", modifier = Modifier.weight(2f)) { viewModel.onAction(CalculatorAction.Number("0")) }
                CalculatorButton(".") { viewModel.onAction(CalculatorAction.Decimal) }
                CalculatorButton("=", backgroundColor = Orange) { viewModel.onAction(CalculatorAction.Calculate) }
            }
        }
    }
}

