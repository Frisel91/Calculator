package com.frisel.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.frisel.calculator.ui.theme.CalculatorTheme
import com.frisel.calculator.ui.theme.MigiumGray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel = viewModel<CalculateViewModel>()
                val state = viewModel.state
                val buttonSpasing = 8.dp
                Calculator(state = state,
                    onAction = viewModel::onAction,
                bottomSpacing = buttonSpasing,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MigiumGray)
                    .padding(16.dp))
            }
        }
    }
}
