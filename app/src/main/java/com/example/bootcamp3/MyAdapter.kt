package com.example.bootcamp3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter (val context:Context, val userList: List<MyDataItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listener: OnItemClickInteractionListener? = null

     inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

         var nodeId: TextView
         var fullName: TextView
         var img : ImageView
         var myDataItem : MyDataItem?= null

         init {
             nodeId = itemView.findViewById(R.id.nodeId)
             fullName = itemView.findViewById(R.id.fullName)
             img = itemView.findViewById(R.id.image)
             /*itemView.setOnClickListener {

             }*/
         }

        fun bindView(myDataItem: MyDataItem){
            this.myDataItem = myDataItem
            nodeId.text = myDataItem.name
            fullName.text = myDataItem.description

            Glide.with(context).load(myDataItem.owner?.avatar_url).into(img)

            itemView.setOnClickListener {
                listener?.onItemClick(myDataItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.bindView(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

interface OnItemClickInteractionListener{
    fun onItemClick(myDataItem: MyDataItem)
}