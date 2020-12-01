package com.example.proyectdebaplaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.proyectdebaplaandroid.adapters.UserAdapter
import com.example.proyectdebaplaandroid.models.AllUsers
import com.example.proyectdebaplaandroid.models.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvUser = findViewById<RecyclerView>(R.id.rvTeamMembers)

        val queue = Volley.newRequestQueue(this)
        val url  = "https://quacklabs.herokuapp.com/about"

        val jsonRequest : StringRequest = StringRequest(Request.Method.GET, url ,
                {response->
                    val manager = Gson()
                    Log.i("User", manager.toString())
                    val allUsers : AllUsers = manager.fromJson(response.toString(),AllUsers::class.java)
                    val users : List<User> = allUsers.equipo

                    rvUser.adapter = UserAdapter(users)
                    rvUser.layoutManager = LinearLayoutManager(this)



            }, { error ->
                    Log.e("JSON","Error en la peticion ${error.toString()}")
            })
        queue.add(jsonRequest)
    }
}
