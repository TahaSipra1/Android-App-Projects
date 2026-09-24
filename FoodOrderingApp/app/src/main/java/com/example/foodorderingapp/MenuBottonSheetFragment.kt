package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.adapter.CartAdapter
import com.example.foodorderingapp.adapter.MenuAdapter
import com.example.foodorderingapp.databinding.FragmentMenuBottonSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottonSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottonSheetBinding
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentMenuBottonSheetBinding.inflate(inflater,container,false)

        var menuFoodName=listOf("Burger","sandwich","mamo","item","sandwich","momo")
        val menuItemPrice=listOf("$5","$6","$7","$8","$9","$10")
        val menuImage=listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
        )
        val adapter= MenuAdapter(ArrayList(menuFoodName),
            ArrayList(menuItemPrice), ArrayList(menuImage)
        )

        binding.menuRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter
        return binding.root

    }

    companion object {

    }
}