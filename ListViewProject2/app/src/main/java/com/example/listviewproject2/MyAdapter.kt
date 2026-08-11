package com.example.listviewproject2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.UiContext
import de.hdodenhof.circleimageview.CircleImageView
import org.w3c.dom.Text

class MyAdapter (val context: Activity,val arrayList: ArrayList<user>):
    ArrayAdapter<user>(context,R.layout.eachitem,arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater= LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.eachitem,null)
        val Image=view.findViewById<CircleImageView>(R.id.profile_image)
        val name=view.findViewById<TextView>(R.id.tvname)
        val lastMsg=view.findViewById<TextView>(R.id.tvLastMsg)
        val lastMsgTime=view.findViewById<TextView>(R.id.tvLastMsgtime)

        name.text=arrayList[position].name
        lastMsg.text=arrayList[position].lastMsg
        lastMsgTime.text=arrayList[position].lastMsgTime
        Image.setImageResource(arrayList[position].ImageId)
        return view
    }
}