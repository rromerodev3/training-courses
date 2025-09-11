package com.roy.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roy.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    ComposeBusinessCard()
                }
            }
        }
    }
}

@Composable
fun ComposeBusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
    ) {
        ComposeInfo(
            name = "Roy",
            title = "Dev"
        )
        Spacer(
            modifier = Modifier.height(250.dp)
        )
        ComposeContact(
            "+00 (00) 000 000",
            "@socialmedia",
            "email@domain.com"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ComposeBusinessCardPreview() {
    ComposeBusinessCard()
}

@Composable
fun ComposeInfo(
    name: String,
    title: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 4.dp)
        )
        Text(
            text = name,
            fontSize = 35.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ComposeInfoPreview() {
    ComposeInfo(
        "Roy",
        "Dev"
    )
}

@Composable
fun ComposeContact(
    phone: String,
    socialMedia: String,
    email: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        ComposeContactElement(
            text = phone
        )
        ComposeContactElement(
            text = socialMedia
        )
        ComposeContactElement(
            text = email
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ComposeContactPreview() {
    ComposeContact(
        "+00 (00) 000 000",
        "@socialmedia",
        "email@domain.com"
    )
}

@Composable
fun ComposeContactElement(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Spacer(
            modifier = Modifier.width(100.dp)
        )
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.padding(2.dp)
        )
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ComposeContactElementPreview() {
    ComposeContactElement(
        "+00 (00) 000 000"
    )
}