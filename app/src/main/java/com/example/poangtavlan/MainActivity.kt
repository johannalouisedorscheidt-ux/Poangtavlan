package com.example.poangtavlan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.poangtavlan.ui.theme.PoangtavlanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PoangtavlanTheme {
                Scoreboard()
            }
        }
    }
}

@Composable
fun TeamCard(name: String) {
    var points by remember { mutableStateOf(0) }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = name)
        Text(text = "$points poäng")

        Column {
            Button(onClick = {
                points = points + 1
            }) {
                Text(text = "+1")
            }

            Button(onClick = {
                points = 0
            }) {
                Text(text = "Nollställ")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamCardPreview() {
    PoangtavlanTheme {
        TeamCard(name = "Flame")
    }
}
@Composable
fun Scoreboard() {
    var finished by remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(32.dp)) {
        Text(text = if (finished) "Matchen är slut" else "Matchen pågår")
        Row {
            TeamCard(name = "Flame")
            TeamCard(name = "Frost")
        }
        Button(onClick = { finished = !finished }) {
            Text(text = if (finished) "Starta igen" else "Avsluta matchen")
        }
    }
}