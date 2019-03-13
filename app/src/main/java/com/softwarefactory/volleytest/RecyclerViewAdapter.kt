package com.softwarefactory.volleytest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(private var list:List<Post>): RecyclerView.Adapter<RecyclerViewAdapter.MyHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val posts = list[position]
        holder.tvTitle.text = posts.title
        holder.tvBody.text = posts.id
    }

    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView
        var tvBody:TextView
        init {
            tvTitle = itemView.findViewById(R.id.tv_title) as TextView
            tvBody = itemView.findViewById(R.id.tv_body) as TextView

        }
    }

}
