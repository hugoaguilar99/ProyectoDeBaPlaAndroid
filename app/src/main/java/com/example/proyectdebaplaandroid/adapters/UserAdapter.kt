package com.example.proyectdebaplaandroid.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectdebaplaandroid.R
import com.example.proyectdebaplaandroid.models.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class UserAdapter(val users : List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    inner class ViewHolder(listItem : View) : RecyclerView.ViewHolder(listItem) {
        val twName : TextView = itemView.findViewById(R.id.textViewName)
        val twLastName : TextView = itemView.findViewById(R.id.textViewLastName)
        val twAge : TextView = itemView.findViewById(R.id.textViewAge)
        val twDescription : TextView = itemView.findViewById(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val userView = inflater.inflate(R.layout.item_user, parent, false)
        return ViewHolder(userView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user : User = users.get(position)
        holder.twName.text = user.name
        holder.twLastName.text = user.lastName
        holder.twAge.text = user.age
        holder.twDescription.text = user.description
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
