package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.adapter.NotificationAdapter
import com.example.foodorderingapp.databinding.FragmentNotificationBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList


class NotificationBottomFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentNotificationBottomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentNotificationBottomBinding.inflate(layoutInflater,container,false)
        val notifications=listOf("Order has been Canceled Successfully","Order has been taken by the driver","Congrats Your Order Pace")
        val notificationImages=listOf(R.drawable.sademoji,R.drawable.truck,R.drawable.congratulation)
        val adapter= NotificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationImages)
        )
        binding.notificationRecyclerview.layoutManager= LinearLayoutManager(requireContext())
        binding.notificationRecyclerview.adapter=adapter
        return binding.root
    }

    companion object {

    }
}