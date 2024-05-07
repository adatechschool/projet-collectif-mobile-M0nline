package com.example.mysurfapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MyScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Look for surfing spot", fontSize = 24.sp)
        Button(onClick = {
            // Todo: Handle button click (e.g., navigation or action)
        }) {
            Text(text = "Start")
        }
    }
}

@Preview
@Composable
fun PreviewMyScreen() {
    MyScreen()
}
