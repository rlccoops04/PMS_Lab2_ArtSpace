package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.unit.sp
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

@Preview(showBackground = true)
@Composable
fun ArtSpace_app(modifier: Modifier = Modifier) {
    ArtSpace_ImageAndButtons(modifier = Modifier
        .fillMaxSize())
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
    Column (modifier = Modifier.fillMaxSize().padding(20.dp),horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(150.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(modifier = Modifier.fillMaxSize(),painter = painterResource(imageResource), contentDescription = currState.toString())
        }
        Spacer(modifier = Modifier.height(50.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = title, fontSize = 50.sp)
            Text(text = descr, fontSize = 40.sp)
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Button(modifier = Modifier.height(50.dp),onClick = {
                currState--;
                if(currState < 1) currState = 1
            }) {
                Text(text = "Previous")
            }
            Button(modifier = Modifier.height(50.dp),onClick = {
                currState++;
                if(currState > 3) currState = 3
            }) {
                Text(text = "Next")
            }
        }
    }
}