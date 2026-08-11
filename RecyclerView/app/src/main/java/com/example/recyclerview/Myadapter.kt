package com.example.recyclerview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Myadapter (var newArrayList: ArrayList<News>, var context: Activity):
RecyclerView.Adapter<Myadapter.MyViewHolder>(){

    private lateinit var myListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setIItemClickListener(listener: onItemClickListener){
        myListener=listener
    }
    //to create new view instance
    //When layout manager fail to find suiatble views for item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter.MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false)
        return MyViewHolder(itemView,myListener)
    }
    //populate items with data
    override fun onBindViewHolder(holder: Myadapter.MyViewHolder, position: Int) {
        var currentitem=newArrayList[position]
        holder.HTittle.text=currentitem.newsHeading
        holder.HImage.setImageResource(currentitem.newsImage)
    }
    //How many List items are present in your array
    override fun getItemCount(): Int {
        return newArrayList.size
    }
    //it holds the view so views are not created everything,so memory can be safe
    class MyViewHolder(itemView: View,listner: onItemClickListener): RecyclerView.ViewHolder(itemView){
        val HTittle=itemView.findViewById<TextView>(R.id.Headingtitle)
        val HImage=itemView.findViewById<ShapeableImageView>(R.id.HeadingImg)

        init {
            itemView.setOnClickListener {
                listner.onItemClick(adapterPosition)
            }
        }
    }
}