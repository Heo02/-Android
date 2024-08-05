package com.example.sy_mmk

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sy_mmk.api.RetrofitClient
import com.example.sy_mmk.api.SearchInfo
import com.example.sy_mmk.api.SearchInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val keyword = intent.getStringExtra("keyword") ?: ""
            ResultScreen(keyword, this)
        }
    }
}

@Composable
fun ResultScreen(keyword: String, context: Context) {
    var searchInfoList by remember {
        mutableStateOf<List<SearchInfo>>(emptyList())
    }


    LaunchedEffect(keyword) {
        fetchSearchInfo(keyword, context) { infoList ->
            searchInfoList = infoList
        }
    }

    SearchInfoList(searchInfoList)
}

fun fetchSearchInfo(keyword: String, context: Context, onResult: (List<SearchInfo>) -> Unit) {
    val call = RetrofitClient.instance.getSearchInfo(
        keyword = keyword
    )

    call.enqueue(object : Callback<SearchInfoResponse> {
        override fun onResponse(call: Call<SearchInfoResponse>, response: Response<SearchInfoResponse>) {
            if (response.isSuccessful) {
                val data = response.body()?.response?.body?.items?.item ?: emptyList()
                Log.d("ResultActivity", "API call successful, received ${data.size} items")
                onResult(data)
            } else {
                Log.e("ResultActivity", "API call failed with response code: ${response.code()}")
                Toast.makeText(context, "API 호출 실패: ${response.message()}", Toast.LENGTH_LONG).show()
                onResult(emptyList())
            }
        }


        override fun onFailure(call: Call<SearchInfoResponse>, t: Throwable) {
            Toast.makeText(context, "데이터 불러오기 실패", Toast.LENGTH_LONG).show()
        }
    })
}

@Composable
fun SearchInfoList(searchInfoList: List<SearchInfo>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(searchInfoList) { info ->
            TouristInfoItem(info)
        }
    }
}

@Composable
fun TouristInfoItem(info: SearchInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = info.title)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "${info.addr1} ${info.addr2 ?: ""}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "수정일: ${info.modifiedtime}")
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ItemPreview() {
}