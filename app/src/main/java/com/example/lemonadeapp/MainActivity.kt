package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                    LemonadeApp()

            }
        }
    }
}


@Composable
fun LemonadeApp() {
    LemonadeTree(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Preview
@Composable
fun LemonadeTree(modifier: Modifier = Modifier) {
    // Declare the page variable
    var page by remember { mutableStateOf(1) }
    // Find the page companion image and text
    val newPair = when(page){
        1 -> Pair(R.drawable.lemon_tree, "Tap the lemon tree to select a lemon")
        2 -> Pair(R.drawable.lemon_squeeze, "Keep tapping the lemon to sequeeze it")
        3 -> Pair(R.drawable.lemon_drink, "Tap the lemonade to drink it")
        else -> Pair(R.drawable.lemon_restart, "Tap the empty glass to start again")
    }
    val (imageResource, text) = newPair

    // The main Box
    Column (modifier = modifier){
        // The header
        Box(
            Modifier
                .background(color = Color(249, 228, 37))
                .fillMaxWidth()
                .height(75.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Lemonade", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        // The body
        Box(modifier, contentAlignment = Alignment.Center) {
            Column (
                modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Button(onClick = {page = if(page>3) 1 else page+1},
                    Modifier
                        .height(220.dp)
                        .width(220.dp),
                    colors = ButtonDefaults.buttonColors(Color(195, 236, 210)),
                    shape = RoundedCornerShape(40.dp)) {
                    Image(
                        painter = painterResource(imageResource),
                        contentDescription = "Lemonade Tree",
                        Modifier.size(180.dp)
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = text, fontSize = 15.sp)
            }
        }
    }
}