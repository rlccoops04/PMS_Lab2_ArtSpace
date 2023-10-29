package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpace_app()
            }
        }
    }
}

@Preview()
@Composable
fun ArtSpace_app(modifier: Modifier = Modifier) {
    ArtSpace_ImageAndButtons()
}

@Composable
fun ArtSpace_ImageAndButtons(modifier: Modifier = Modifier) {
    var currState by remember { mutableStateOf(1) }
    val imageResource = when(currState) {
        1 -> R.drawable.art1
        2 -> R.drawable.art2
        else -> R.drawable.art3
    }
    val title = when(currState) {
        1 -> "Title1"
        2 -> "Title2"
        else -> "Title3"
    }
    val descr = when(currState) {
        1 -> "Author1"
        2 -> "Author2"
        else -> "Author3"
    }
    Column () {
        Column {
            Image(painter = painterResource(imageResource), contentDescription = currState.toString())
        }
        Column {
            Text(text = title)
            Text(text = descr)
        }
        Row {
            Button(onClick = {
                currState--;
                if(currState < 0) currState = 3
            }) {
                Text(text = "Previous")
            }
            Button(onClick = {
                currState++;
                if(currState > 3) currState = 0
            }) {
                Text(text = "Next")
            }
        }
    }
}