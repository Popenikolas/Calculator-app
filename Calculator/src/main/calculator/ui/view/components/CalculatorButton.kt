
package com.example.calculator.ui.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.MediumGray
import com.example.calculator.ui.theme.White

/**
 * A reusable Composable for a single calculator button.
 * This improves code organization and reusability.
 */
@Composable
fun RowScope.CalculatorButton(
    text: String,
    modifier: Modifier = Modifier.weight(1f),
    textColor: Color = White,
    backgroundColor: Color = MediumGray,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick),
        color = backgroundColor,
        elevation = 4.dp,
        shape = CircleShape
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.height(70.dp)
        ) {
            Text(
                text = text,
                color = textColor,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}