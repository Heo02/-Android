package com.example.fitnessequipment


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ParkAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        printData()
    }


    private fun printData() {
        // 가상의 공원 데이터
        val parks = mutableListOf(
            Park("공원1", "위치1", "운동기구: 기구1, 기구2, 기구3"),
            Park("공원2", "위치2", "운동기구: 기구4, 기구5"),
            Park("공원3", "위치3", "운동기구: 기구6, 기구7, 기구8"),
            Park("공원4", "위치4", "운동기구: 기구9, 기구10"),
            Park("공원5", "위치5", "운동기구: 기구11, 기구12")
        )

        adapter = ParkAdapter(this, parks)
        recyclerView.adapter = adapter

//        adapter.setOnItemClickListener { park ->
//            val intent = Intent(this@MainActivity, EquipmentActivity::class.java).apply {
//                putExtra("parkName", park.name)
//                putExtra("equipmentList", park.equipment)
//            }
//            startActivity(intent)
//        }
    }

//    private fun fetchParksData() {
       /* val url = URL("YOUR_API_URL_HERE") // API URL을 입력하세요
        GlobalScope.launch(Dispatchers.IO) {
            val connection = url.openConnection() as HttpURLConnection
            try {
                val inputStream = connection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                val stringBuilder = StringBuilder()
                var line: String?
                while (bufferedReader.readLine().also { line = it } != null) {
                    stringBuilder.append(line)
                }
                bufferedReader.close()
                val jsonArray = JSONArray(stringBuilder.toString())
                val parks = mutableListOf<Park>()

                for (i in 0 until jsonArray.length()) {
                    val parkObject = jsonArray.getJSONObject(i)
                    val park = Park(
                        parkObject.getString("name"),
                        parkObject.getString("location"),
                        parkObject.getString("equipment")
                    )
                    parks.add(park)
                }

                launch(Dispatchers.Main) {
                    adapter = ParkAdapter(parks)
                    recyclerView.adapter = adapter

                    adapter.setOnItemClickListener { park ->
                        val intent = Intent(this@MainActivity, ParkDetailActivity::class.java).apply {
                            putExtra("parkName", park.name)
                            putExtra("equipmentList", park.equipment)
                        }
                        startActivity(intent)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                connection.disconnect()
            }
        } */
//    }
}
