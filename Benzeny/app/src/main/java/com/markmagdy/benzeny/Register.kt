package com.markmagdy.benzeny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun signup(view: View) {
        val a= Intent(this,signup::class.java)
        startActivity(a)

    }

    fun login(view: View) {
        val x=Intent(this@Register,vehicletype::class.java)
        startActivity(x)
    }
}