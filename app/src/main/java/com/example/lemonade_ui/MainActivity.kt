package com.example.lemonade_ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.example.lemonade_ui.ui.theme.Lemonade_uiTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lemonade_uiTheme {

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                  LemonadeUi()
                }
            }
        }
    }
}

@Composable
fun LemonadeUi() {
    var value by remember { mutableStateOf(1) }

    val image = when (value) {
        1 -> painterResource(R.drawable.lemon_tree)
        2 -> painterResource(R.drawable.lemon_squeeze)
        3 -> painterResource(R.drawable.lemon_drink)
        4 -> painterResource(R.drawable.lemon_restart)
        else -> painterResource(R.drawable.lemon_tree)
    }

    val text = when (value) {
        1 -> "Tap the lemon tree to select a lemon 🍋"
        2 -> "Keep tapping the lemon to squeeze it! 💪"
        3 -> "Tap the lemonade to drink it 🥤"
        4 -> "Tap the empty glass to start again 🔄"
        else -> "Tap the lemon tree to select a lemon 🍋"
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(color = Color.LightGray)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    if (value == 4) {
                        value = 1
                    } else {
                        value += 1
                    }
                }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}