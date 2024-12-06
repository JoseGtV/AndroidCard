package com.example.businesscard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View.OnClickListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface() {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderSection(
            modifier = Modifier
                .weight(1f)
        )
        ContactSection(
            modifier = Modifier
                .padding(16.dp)
        )

    }

}


@Composable
fun HeaderSection(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Black, shape = CircleShape),
            contentAlignment = Alignment.Center
        ){
            ImageContent()
        }
        //Title
        Text(
            text = "José Gustavo da Silva Oliveira  ",
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
        )
        //Name
        Text(
            text = "Android Developer",
            style = TextStyle(fontSize = 16.sp)
        )


    }

}

@Composable
fun ContactSection(modifier: Modifier = Modifier){
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        //Telefone
        ContactIcon(
            icon = R.drawable.call_24dp_e8eaed,
            text = "+55 (15) 99862-0991",
            onClick = {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:(00)000000000")
                }
                context.startActivity(intent)
            }

        )
        ContactIcon(
            icon = R.drawable.share_24dp_e8eaed,
            text = "@Linkedin",
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://www.linkedin.com/in/josé-gustavo-oliveira/")
                }
                context.startActivity(intent)
            }
        )
        ContactIcon(
            icon = R.drawable.email_24dp_e8eaed,
            text = "User@domain.com",
            onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:User@domain.com")
                }
                context.startActivity(intent)
            }
        )
    }
}

@Composable
fun ContactIcon(icon: Int, text : String, onClick : () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, shape = CircleShape)
            .clickable(onClick = onClick)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp)
        )
        Text(
            text = text,
            style = TextStyle(fontSize = 16.sp)
        )
    }
}



@Composable
fun ImageContent(modifier: Modifier = Modifier){
    val androidImage = painterResource(R.drawable.android_logo)
    Image(
        painter = androidImage,
        contentDescription = "Android Logo",
        modifier = modifier
            .size(80.dp)
    )


}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        MainScreen()
    }
}