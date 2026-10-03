package com.example.foodorderingapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuItemImpl
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.DetailsActivity
import com.example.foodorderingapp.databinding.BuyAgainItemBinding
import com.example.foodorderingapp.databinding.MenuItemBinding

class MenuAdapter(private val menuItemsName: MutableList<String>, private val menuItemPrice: MutableList<String>,private val MenuImage: MutableList<Int>, private val requireContext: Context): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private val itemClickListner: View.OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: MenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListner?.onItemClick(position)
                }
                //setonClick Listner to open Details

                val intent = Intent(requireContext, DetailsActivity::class.java)
                intent.putExtra("MenuItemName", menuItemsName.get(position))
                intent.putExtra("MenuItemImage", MenuImage.get(position))
                requireContext.startActivity(intent)
            }
        }

        fun bind(position: Int) {
            binding.apply {
                menuFoodname.text = menuItemsName[position]
                menuPrice.text = menuItemPrice[position]
                menuImage.setImageResource(MenuImage[position])


            }
        }

    }



}

private fun View.OnClickListener?.onItemClick(position: Int) {

}





