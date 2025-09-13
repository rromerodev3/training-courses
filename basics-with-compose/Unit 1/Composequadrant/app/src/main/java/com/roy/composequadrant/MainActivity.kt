package com.roy.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roy.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    QuadrantColumn(
                        title1 = stringResource(R.string.text_composable_title),
                        body1 = stringResource(R.string.text_composable_body),
                        color1 = Color(0xFFEADDFF),
                        title2 = stringResource(R.string.image_composable_title),
                        body2 = stringResource(R.string.image_composable_body),
                        color2 = Color(0xFFD0BCFF),
                        title3 = stringResource(R.string.row_composable_title),
                        body3 = stringResource(R.string.row_composable_body),
                        color3 = Color(0xFFB69DF8),
                        title4 = stringResource(R.string.column_composable_title),
                        body4 = stringResource(R.string.column_composable_body),
                        color4 = Color(0xFFF6EDFF),
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun QuadrantColumn(
    title1: String,
    body1: String,
    color1: Color,
    title2: String,
    body2: String,
    color2: Color,
    title3: String,
    body3: String,
    color3: Color,
    title4: String,
    body4: String,
    color4: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        QuadrantRow(
            title1 = title1,
            body1 = body1,
            color1 = color1,
            title2 = title2,
            body2 = body2,
            color2 = color2,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
        QuadrantRow(
            title1 = title3,
            body1 = body3,
            color1 = color3,
            title2 = title4,
            body2 = body4,
            color2 = color4,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun RowQuadrantPreview() {
    QuadrantColumn(
        title1 = stringResource(R.string.text_composable_title),
        body1 = stringResource(R.string.text_composable_body),
        color1 = Color(0xFFEADDFF),
        title2 = stringResource(R.string.image_composable_title),
        body2 = stringResource(R.string.image_composable_body),
        color2 = Color(0xFFD0BCFF),
        title3 = stringResource(R.string.row_composable_title),
        body3 = stringResource(R.string.row_composable_body),
        color3 = Color(0xFFB69DF8),
        title4 = stringResource(R.string.column_composable_title),
        body4 = stringResource(R.string.column_composable_body),
        color4 = Color(0xFFF6EDFF),
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun QuadrantRow(
    title1: String,
    body1: String,
    color1: Color,
    title2: String,
    body2: String,
    color2: Color,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Quadrant(
            title = title1,
            body = body1,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(color1)
        )
        Quadrant(
            title = title2,
            body = body2,
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(color2)
        )
    }
}

@Preview
@Composable
private fun QuadrantRowPreview() {
    QuadrantRow(
        title1 = "Row composable",
        body1 = "A layout composable that places its children in a horizontal sequence.",
        color1 = Color(0xFFB69DF8),
        title2 = "Column composable",
        body2 = "A layout composable that places its children in a vertical sequence.",
        color2 = Color(0xFFF6EDFF),
        modifier = Modifier
            .width(400.dp)
            .height(400.dp)
    )
}

@Composable
fun Quadrant(
    title: String,
    body: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = body,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun QuadrantPreview(
) {
    ComposeQuadrantTheme {
        Quadrant(
            title = "Text composable",
            body = "Displays text and follows the recommended Material Design guidelines",
            modifier = Modifier
                .width(200.dp)
                .height(400.dp)
                .background(Color.Red),
        )
    }
}