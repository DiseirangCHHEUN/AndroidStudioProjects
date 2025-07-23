package com.diseirang.businesscard

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diseirang.businesscard.ui.theme.BusinessCardTheme
import com.diseirang.businesscard.ui.theme.DarkGreen
import com.diseirang.businesscard.ui.theme.mailTo
import com.diseirang.businesscard.ui.theme.phoneNumber
import com.diseirang.businesscard.ui.theme.position
import com.diseirang.businesscard.ui.theme.shareTo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xFFD8FFE5)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier.weight(1f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = modifier
                    .width(150.dp)
                    .height(160.dp)
                    .padding(16.dp)
                    .background(Color(0xFF001E1E)),
                contentAlignment = Alignment.Center,
            ) {
                CImage(
                    painter = image, contentScale = ContentScale.Fit
                )
            }
            Text(
                "Jennifer Doe",
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                position, fontWeight = FontWeight.Bold, color = DarkGreen
            )
        }
        Spacer(modifier.weight(1f))

        Column(verticalArrangement = Arrangement.Center) {
            val phone = painterResource(R.drawable.phone_24dp_e3e3e3)
            val share = painterResource(R.drawable.share_24dp_e3e3e3)
            val mail = painterResource(R.drawable.email_24dp_e3e3e3)

            SocialLink(
                painter = phone, label = phoneNumber
            )
            SocialLink(
                painter = share, label = shareTo
            )
            SocialLink(
                painter = mail, label = mailTo
            )
        }

        Spacer(modifier.height(16.dp))
    }
}

@Composable
fun SocialLink(painter: Painter, label: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = modifier
                .width(20.dp)
                .height(20.dp),
            tint = DarkGreen,
            painter = painter,
            contentDescription = null,

            )
        Spacer(modifier.width(16.dp))
        Text(
            label, fontSize = 16.sp
        )
    }
}

@Preview(
    showBackground = true, showSystemUi = false, uiMode = Configuration.UI_MODE_TYPE_DESK
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}