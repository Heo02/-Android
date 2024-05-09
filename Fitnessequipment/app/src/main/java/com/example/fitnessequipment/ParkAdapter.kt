package com.example.fitnessequipment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessequipment.databinding.ItemParkBinding

//class ParkAdapter : ListAdapter<Item, ParkAdapter.ParkViewHolder>(ParkCallback) {
//
//    class ParkViewHolder(private val binding: ItemParkBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: Item) {
//            with(binding) {
//                nameTextView.text = item.parkNm
//                locationTextView.text = item.lotNoAddr
//            }
//        }
//    }
//    companion object {
//        private val ParkCallback = object : DiffUtil.ItemCallback<Item>() {
//            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
//                return oldItem.hashCode() == newItem.hashCode()
//            }
//
//            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//
//}




class ParkAdapter(private val context: Context, private val parks: List<Park>) :
    RecyclerView.Adapter<ParkAdapter.ParkViewHolder>() {

    inner class ParkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val locationTextView: TextView = itemView.findViewById(R.id.locationTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_park, parent, false)
        return ParkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParkViewHolder, position: Int) {
        val park = parks[position]
        holder.nameTextView.text = park.name
        holder.locationTextView.text = park.location

        holder.itemView.setOnClickListener {
            val intent = Intent(context, EquipmentActivity::class.java).apply {
                putExtra("parkName", park.name)
                putExtra("equipmentList", park.equipment)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return parks.size
    }
}
