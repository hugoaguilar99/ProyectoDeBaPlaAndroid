package com.example.proyectdebaplaandroid

import android.app.VoiceInteractor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue = Volley.newRequestQueue(this)
        val url  = "https://quacklabs.herokuapp.com/about"

        val jsonRequest : StringRequest = StringRequest(Request.Method.GET, url ,
            Response.Listener {response->
                Log.i("JSON", response.toString())
        }, Response.ErrorListener { error ->
                Log.e("JSON","Error en la peticion ${error.toString()}")
        } )
        queue.add(jsonRequest)
    }
}