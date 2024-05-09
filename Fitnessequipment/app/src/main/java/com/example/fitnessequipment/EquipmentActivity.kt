package com.example.fitnessequipment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EquipmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipment)

        val parkName = ""
//            intent.getStringExtra("parkName")
        val equipmentList = ""
//            intent.getStringExtra("equipmentList")

        val parkNameTextView = findViewById<TextView>(R.id.parkNameTextView)
        val equipmentListTextView = findViewById<TextView>(R.id.equipmentListTextView)

        parkNameTextView.text = parkName
        equipmentListTextView.text = equipmentList
    }
}
