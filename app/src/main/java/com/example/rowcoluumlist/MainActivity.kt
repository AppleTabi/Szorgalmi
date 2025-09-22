package com.example.rowcoluumlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rowcoluumlist.ui.theme.RowColuumListTheme
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.random.Random
import kotlin.uuid.Uuid
import kotlin.uuid.Uuid.Companion.random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowColuumListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Oszlop(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Oszlop(modifier: Modifier = Modifier) {
    var red by remember { mutableIntStateOf(255) }
    var green by remember { mutableIntStateOf(255) }
    var blue by remember { mutableIntStateOf(255) }
    var osszeg by remember { mutableIntStateOf(0) }

    var poziPiros by remember { mutableFloatStateOf(0f) }
    var poziZold by remember { mutableFloatStateOf(0f) }
    var pozikek by remember { mutableFloatStateOf(0f) }
    var poziOsszeg by remember { mutableFloatStateOf(0f) }
    poziOsszeg = poziPiros+poziZold+pozikek

    //Text
    //Button
    Column(
        modifier = modifier.fillMaxSize().background(Color(Math.round(poziPiros), Math.round(poziZold), Math.round(pozikek))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column (modifier= Modifier.padding(15.dp)){
            Slider(
            value = poziPiros,
            valueRange = 0f..255f,
            onValueChange = { poziPiros = it}
        )

            Slider(
                value = poziZold,
                valueRange = 0f..255f,
                onValueChange = {poziZold = it}
            )

            Slider(
                value = pozikek,
                valueRange = 0f..255f,
                onValueChange = {pozikek = it}
            ) }


        Text(
            color = when {
                poziOsszeg < 200 -> Color.White
                poziOsszeg > 200 -> Color.Black
                else -> Color.Black
            },
            fontSize = 25.sp,
            text = "Red: ${Math.round(poziPiros)}")
        Spacer(Modifier.height(16.dp))

        Text(
            color = when {
                poziOsszeg < 200 -> Color.White
                poziOsszeg > 200 -> Color.Black
                else -> Color.Black
            },
            fontSize = 25.sp,
            text = "Green: ${Math.round(poziZold)}")
        Spacer(Modifier.height(16.dp))

        Text(
            color = when {
                poziOsszeg < 200 -> Color.White
                poziOsszeg > 200 -> Color.Black
                else -> Color.Black
            },
            fontSize = 25.sp,
            text = "Blue: ${Math.round(pozikek)}")
        Spacer(Modifier.height(25.dp))

        Text(
            color = when {
                poziOsszeg < 200 -> Color.White
                poziOsszeg > 200 -> Color.Black
                else -> Color.Black
            },
            fontSize = 25.sp,
            text = "(${Math.round(poziPiros)}, ${Math.round(poziZold)}, ${Math.round(pozikek)})")
        //Spacer(Modifier.height(16.dp))
        /*Button(
            onClick = {

                red = Random.nextInt(255)
                green = Random.nextInt(255)
                blue = Random.nextInt(255)
                osszeg = red+green+blue
            }
        ) {
            Text("Random szín generálás")
        }*/
    }
}