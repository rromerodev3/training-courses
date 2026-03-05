package com.roy.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roy.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpace(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {

    var state by remember { mutableIntStateOf(0) }
    val image = when(state) {
        0 -> R.drawable.wallpaper1
        1 -> R.drawable.wallpaper2
        else -> R.drawable.wallpaper3
    }

    Column(
        modifier = modifier
    ) {
        ArtworkWall(
            imageId = image,
            modifier = Modifier.weight(1f)
        )
        ArtworkDescriptor(
            "Artwork Title ${state + 1}",
            "Artwork Subtitle ${state+1}"
        )
        DisplayController(
            onPrevious = {
                if (state > 0) state--
                else state = 2
            }
            ,
            onNext = {
                if (state < 2) state++
                else state = 0
            }
        )
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(imageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()
            .padding(0.dp, 0.dp, 0.dp, 0.dp)
    )
}

@Composable
fun ArtworkDescriptor(
    title: String,
    sutTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 0.dp, top = 8.dp, end = 0.dp, bottom = 0.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = sutTitle,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 0.dp, horizontal = 4.dp)
        )
    }
}

@Composable
fun DisplayController(
    modifier: Modifier = Modifier,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp, 4.dp)
    ) {
        Button(
            modifier = Modifier.weight(1f),
            onClick = onPrevious,
        ) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.width(4.dp))
        Button(
            modifier = Modifier.weight(1f),
            onClick = onNext
        ) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ArtSpacePrev() {
    ArtSpace(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 8.dp)
    )
}