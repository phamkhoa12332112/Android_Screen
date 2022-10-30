package com.example.androidscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidscreen.ui.theme.AndroidScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier
                    .fillMaxSize()
                ){
                    AndroidScreen()
                }
            }
        }
    }
}

@Composable
fun AndroidScreen() {
    Column(
        modifier = Modifier
//            .height(510.dp)
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0, 58, 74)),
    ) {
        Column(
            modifier = Modifier
//                .height(340.dp)
                .weight(3f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val image = painterResource(R.drawable.android_logo)
            Image(
                painter = image,
                contentDescription = null,
                modifier  = Modifier
                    .height(100.dp)
                    .wrapContentSize(),
                contentScale = ContentScale.Fit
            )
            Text(
                text = "Jennifer Doe",
                fontSize = 50.sp,
                color = Color.White
            )
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 20.sp,
                color = Color(0xFF3ddc84)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .height(170.dp)
                .weight(1f)
        ) {

            Divider(color = Color(0xFF3ddc84), thickness = 1.dp)

            InformationRow(
                text = "+11 (123) 444 555 666",
                painter = rememberVectorPainter(Icons.Rounded.Phone)
            )

            Divider(color = Color(0xFF3ddc84), thickness = 1.dp)

            InformationRow(
                text = "@AndroidDev",
                painter = rememberVectorPainter(Icons.Rounded.Share)
            )

            Divider(color = Color(0xFF3ddc84), thickness = 1.dp)

            InformationRow(
                text = "jen.doe@android.com",
                painter = rememberVectorPainter(Icons.Rounded.Email)
            )
        }
    }
}

@Composable
private fun InformationBottom(
    title: String,
) {
    Text(
        text = title,
        color = Color.White
    )
}

@Composable
private fun InformationRow(
    text: String,
    painter: VectorPainter,
){
    Row(
        modifier = Modifier
            .padding(start = 50.dp,  top = 10.dp, bottom = 10.dp)
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = Color(0xFF3ddc84))
        Spacer(modifier = Modifier.padding(start = 20.dp))
        InformationBottom(title = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidScreenTheme {
        AndroidScreen()
    }
}