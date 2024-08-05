package com.example.sy_mmk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchScreen()
        }
    }
}

@Composable
fun SearchScreen() {
    var keyword by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    fun startSearch() {
        val intent = Intent(context, ResultActivity::class.java).apply {
            putExtra("keyword", keyword)
        }
        context.startActivity(intent)
    }

    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment =Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "지역 명을 입력하세요.(ex: 서울)",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding()
                )
            }
            OutlinedTextField(
                value = keyword,
                onValueChange = { keyword = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            Button(
                onClick = { startSearch() },
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(50.dp)
                ){
                Text(text = "검색하기")
            }
        }
    }
}





@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_5")
@Composable
fun GreetingSearchPreview() {
    SearchScreen()
}