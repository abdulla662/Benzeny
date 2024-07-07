package com.markmagdy.benzeny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class vehicletype : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicletype)
    }

    fun car(view: View) {
     val a=Intent(this,ChooseActivity::class.java)
        startActivity(a)
    }
    fun moto(view: View) {
        val a=Intent(this,Motor::class.java)
        startActivity(a)
    }

}