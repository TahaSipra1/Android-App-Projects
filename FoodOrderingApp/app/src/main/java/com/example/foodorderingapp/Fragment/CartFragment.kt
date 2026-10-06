package com.example.foodorderingapp.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.CongratsBottomSheet
import com.example.foodorderingapp.PayOutActivity
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.CartAdapter
import com.example.foodorderingapp.databinding.FragmentCartBinding


class CartFragment : Fragment() {
   private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentCartBinding.inflate(inflater,container,false)

        var cartFoodName=listOf("Burger","Salad","Ice-Cream","Samosa","sandwich","momo","Shawarma","Pasta","Fries")
        val cartItemPrice=listOf("$5","$6","$7","$8","$9","$10","$7","$8","$9","$10")
        val cartImage=listOf(
            R.drawable.burger,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.samosa,
            R.drawable.sandwich,
            R.drawable.momo,
            R.drawable.shawarma,
            R.drawable.menu5,
            R.drawable.fries
        )
        val adapter= CartAdapter(ArrayList(cartFoodName),
            ArrayList(cartItemPrice), ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter=adapter

        binding.proceedButton.setOnClickListener {
            val intent= Intent(requireContext(), PayOutActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    companion object {
    }
}