package com.example.foodorderingapp.Fragment

import android.app.DownloadManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.adapter.MenuAdapter
import com.example.foodorderingapp.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    private lateinit var  adapter: MenuAdapter

    private val originalFoodName=listOf("Burger","sandwich","mamo","item","sandwich","momo","mamo","item","sandwich","momo")
    private val originalmenuItemPrice=listOf("$5","$6","$7","$8","$9","$10","$7","$8","$9","$10")
    private val originalmenuImage=listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val filteredMenufoodName= mutableListOf<String>()
    private val filteredMenuItemPrice=  mutableListOf<String>()
    private val filteredMenuImage= mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSearchBinding.inflate(inflater,container,false)
        adapter= MenuAdapter(filteredMenufoodName,filteredMenuItemPrice,filteredMenuImage)
        binding.menuRecyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter=adapter

        //seetup for search view
        setupsearchView()
        //show All menu Items
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu(){
        filteredMenufoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenufoodName.addAll(originalFoodName)
        filteredMenuItemPrice.addAll(originalmenuItemPrice)
        filteredMenuImage.addAll(originalmenuImage)

        adapter.notifyDataSetChanged()
    }

    private fun setupsearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                filterMenuItems(query)
                return true
            }
        })
    }
    private fun filterMenuItems(query: String) {
        filteredMenufoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalFoodName.forEachIndexed { index, foodName ->
            if(foodName.contains(query, ignoreCase = true)){
                filteredMenufoodName.add(foodName)
                filteredMenuItemPrice.add(originalmenuItemPrice[index])
                filteredMenuImage.add(originalmenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}


