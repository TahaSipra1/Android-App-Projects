package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodorderingapp.databinding.FragmentMenuBottonSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class MenuBottonSheetFragment : BottomSheetDialogFragment() {
    private lateinit var bindind: FragmentMenuBottonSheetBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       bindind= FragmentMenuBottonSheetBinding.inflate(inflater,container,false)
        return bindind.root
    }

    companion object {

    }
}