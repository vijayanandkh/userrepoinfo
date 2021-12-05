package com.example.userrepoinfo.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userrepoinfo.R
import com.example.userrepoinfo.data.ReposModel

class ReposAdapter(var reposList: List<ReposModel>) : RecyclerView.Adapter<ReposAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.repositem,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = reposList!!.size

    override fun onBindViewHolder(holder: ReposAdapter.RepoViewHolder, position: Int) {
        holder.bind(reposList!!.get(position))
    }

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var name: TextView
        lateinit var description: TextView



        fun bind(item: ReposModel?) {


            name = itemView.findViewById(R.id.name)
            description = itemView.findViewById(R.id.description)
        }
    }
    interface RepoClickListener{
        fun onclickRepo()
    }
}