package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonApp() {

    var step by remember { mutableIntStateOf(1) }
    var randomSteps by remember { mutableIntStateOf(0) }

    when(step) {
        1 -> TreeScreen {
            step++
            randomSteps = (2..4).random()
        }
        2 -> LemonScreen {
            if (randomSteps <= 1) step++
            else randomSteps--
        }
        3 -> LemonadeScreen { step++ }
        else -> EmptyScreen {
            step = 1
        }
    }
}

@Composable
fun Screen(
    modifier: Modifier = Modifier,
    image: Int,
    description: Int,
    text: Int,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(image),
            contentDescription = stringResource(description),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFD7F5E3))
                .border(
                    width = 2.dp,
                    color = Color(0xFFD7F5E3),
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable {
                    onClick()
                }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            stringResource(text),
            fontSize = 18.sp,
        )
    }
}

@Composable
fun TreeScreen(
    onClick: () -> Unit
) {
    Screen(
        image = R.drawable.lemon_tree,
        description = R.string.lemon_tree_content_description,
        text = R.string.step1,
        onClick = onClick
    )
}

@Composable
fun LemonScreen(
    onClick: () -> Unit
) {
    Screen(
        image = R.drawable.lemon_squeeze,
        description = R.string.lemon_content_description,
        text = R.string.step2,
        onClick = onClick
    )
}

@Composable
fun LemonadeScreen(
    onClick: () -> Unit
) {
    Screen(
        image = R.drawable.lemon_drink,
        description = R.string.glass_content_description,
        text = R.string.step3,
        onClick = onClick
    )
}

@Composable
fun EmptyScreen(
    onClick: () -> Unit
) {
    Screen(
        image = R.drawable.lemon_restart,
        description = R.string.empty_content_description,
        text = R.string.step4,
        onClick = onClick
    )
}

@Preview(showBackground = true)
@Composable
private fun TreeScreenPreview() {
    TreeScreen{}
}

@Preview(showBackground = true)
@Composable
private fun LemonScreenPreview() {
    LemonScreen{}
}

@Preview(showBackground = true)
@Composable
private fun LemonadeScreenPreview() {
    LemonadeScreen{}
}

@Preview(showBackground = true)
@Composable
private fun EmptyScreenPreview() {
    EmptyScreen{}
}