package com.example.mysurfapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class SurfData : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    SpotListScreen()
                }
            }
        }
    }
}

data class Spot(val name: String, val location: String, val imageResourceId: Int)

fun displaySpotList(): List<Spot> {
    val spotNames = arrayOf(
        "Banzai Pipeline",
        "Trestles",
        "Jeffreys Bay",
        "Hossegor",
        "Teahupo'o",
        "Snapper Rocks",
        "Mavericks",
        "Cloudbreak",
        "Supertubes",
        "Jaws"
    )
    val spotLocations = arrayOf(
        "Oahu, Hawaii",
        "California, USA",
        "Eastern Cape, South Africa",
        "Landes, France",
        "Tahiti, French Polynesia",
        "Queensland, Australia",
        "California, USA",
        "Tavarua, Fiji",
        "Eastern Cape, South Africa",
        "Maui, Hawaii"
    )

    // Array of drawable resource IDs representing images
    val imageResourceIds = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10
    )

    val spots = mutableListOf<Spot>()
    val random = Random.Default
    for (i in spotNames.indices) {
        val randomImageResourceId = imageResourceIds[random.nextInt(imageResourceIds.size)]
        spots.add(Spot(spotNames[i], spotLocations[i], randomImageResourceId))
    }
    return spots
}

@Composable
fun SpotListScreen() {
    val spots = displaySpotList()
    val selectedSpotIndex = remember { mutableStateOf(-1) } // Index of the selected spot, -1 if none selected

    Column {
        spots.forEachIndexed { index, spot ->
            Column(
                modifier = Modifier.clickable {
                    selectedSpotIndex.value = index // Update the selected spot index when clicked
                }
            ) {
                Text(
                    text = "${spot.name} - ${spot.location}",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )
                if (selectedSpotIndex.value == index) {
                    Image(
                        painter = painterResource(id = spot.imageResourceId),
                        contentDescription = null, // Provide content description if needed
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpotListPreview() {
    MaterialTheme {
        SpotListScreen()
    }
}
