package com.example.apiapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


class MyAdapter(val context: Activity,val productarrayList: List<Product>):
    RecyclerView.Adapter<MyAdapter.MyviewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {

        val itemview= LayoutInflater.from(context).inflate(R.layout.eachrow,parent,false)
        return MyviewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem=productarrayList[position]
        holder.tittle.text=currentItem.title
        //image view,how to sho in image if the image is in form of url,3rd party library
        //picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image)

    }

    override fun getItemCount(): Int {
        return productarrayList.size
    }

    class MyviewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        var tittle: TextView
        var image: ShapeableImageView

        init {
            tittle=itemview.findViewById(R.id.Producttitle)
            image=itemview.findViewById(R.id.ProductImg)
        }

    }

}