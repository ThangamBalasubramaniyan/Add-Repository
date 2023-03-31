package com.example.firstzoomtask

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(var list: RepoList, var itemClick: hospitalClickListener, var shareItem: shareClickListner) : RecyclerView.Adapter<EmployeeAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list, parent, false)
        return RecyclerViewHolder(view, itemClick, shareItem)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface hospitalClickListener {
        fun getItem(position: Int)
    }

    interface shareClickListner {
        fun shareItem(position: Int)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bindData(list, position)
    }

    class RecyclerViewHolder(itemView: View, var itemClick: hospitalClickListener, var shareItem: shareClickListner) : RecyclerView.ViewHolder(itemView) {
        var textName: TextView = itemView.findViewById(R.id.name)
        var textAddress: TextView = itemView.findViewById(R.id.mail)
        var button: ImageButton = itemView.findViewById(R.id.imageButton)
        fun bindData(userList: RepoList, position: Int) {
            textName.text = userList.get(position).name
            textAddress.text = userList.get(position).description
            itemView.setOnClickListener(View.OnClickListener {
                itemClick.getItem(adapterPosition)
            })
            button.setOnClickListener(View.OnClickListener {
                shareItem.shareItem(adapterPosition)
            })
        }
    }
}