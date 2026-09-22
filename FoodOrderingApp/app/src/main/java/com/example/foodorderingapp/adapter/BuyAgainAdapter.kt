package com.example.foodorderingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainFoodName: ArrayList<String>,private val buyAgainfoodPrice: ArrayList<String>,
                      private val buyAgainfoodIamge: ArrayList<Int>):
    RecyclerView.Adapter<BuyAgainAdapter.BuyagianViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyagianViewHolder {
        val binding= BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyagianViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyagianViewHolder, position: Int) {
       holder.bind(buyAgainFoodName[position],buyAgainfoodPrice[position],buyAgainfoodIamge[position])
    }

    override fun getItemCount(): Int =buyAgainFoodName.size

    class BuyagianViewHolder(private val binding: BuyAgainItemBinding): RecyclerView.ViewHolder (binding.root){
        fun bind(foodName: String, foodPrice: String, foodImage: Int) {
            binding.buyAgainFoodName.text=foodName
            binding.BuyAgainFoodPrice.text=foodPrice
            binding.BuyAgainFoodImage.setImageResource(foodImage)
        }


    }
}