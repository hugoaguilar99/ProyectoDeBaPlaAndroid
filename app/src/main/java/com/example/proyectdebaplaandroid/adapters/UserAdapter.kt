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
        val ivImage : ImageView = itemView.findViewById(R.id.imageViewPortfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val teamMemberView = inflater.inflate(R.layout.item_user, parent, false)
        return ViewHolder(teamMemberView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user : User = users.get(position)
        holder.twLastName.text = user.name
        holder.twLastName.text = user.lastName
        holder.twAge.text = user.age
        Picasso.get()
                .load("https://quacklabs.herokuapp.com${user.img}")
                .into(holder.ivImage, object: Callback {
                    override fun onSuccess() {
                        //set animations here
                        Log.d("TeamMemberAdapter", "Success loading ${user.name}'s foto!")
                    }

                    override fun onError(e: Exception?) {
                        Log.e("TeamMemberAdapter", "Couldnt load images: " + e.toString())
                    }
                })
    }

    override fun getItemCount(): Int {
        return users.size
    }
}
