package com.example.mysurfapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

@Composable
fun MyScreen() {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Background Image
            Image(
                painter = painterResource(id = R.drawable.surfhome),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            // Transparent Box
            Box(
                modifier = Modifier.size(381.dp, 466.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0x40FFFFFF)) // Custom color
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                // Align elements in center like a column
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Title TextView
                    Text(
                        text = "THE PERFECT SPOTS",
                        textAlign = TextAlign.Center,
                        lineHeight = 1.em,
                        fontSize = 44.sp,
                        color = Color.White, // Custom text color
                        modifier = Modifier.padding(top = 16.dp),
                    )

                    // Start Button
                    Button(
                        onClick = {
                            // Todo: Handle button click (e.g., navigation or action)
                        },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text(text = "Start")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyScreen() {
    MyScreen()
}
