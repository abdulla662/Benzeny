package com.markmagdy.benzeny

import android.content.Intent
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class location : AppCompatActivity() {
    lateinit var From1:EditText
    lateinit var to:EditText
    lateinit var rere:TextView
    var distance:Double=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
         From1=findViewById(R.id.From1)
        to=findViewById(R.id.to)
    }

    fun show(view: View) {
        val adress=From1.text.toString()  + ", Egypt"
        val g=Geocoder(this)
        val adresslist=g.getFromLocationName(adress,1)
        val lat=adresslist?.get(0)?.latitude
        val long=adresslist?.get(0)?.longitude
        val loc1=Location("")
        loc1.latitude=lat!!
        loc1.longitude=long!!

        val adress1=to.text.toString()  + ", Egypt"
        val g1=Geocoder(this)
        val adresslist1=g1.getFromLocationName(adress1,1)
        val lat1=adresslist1?.get(0)?.latitude
        val long1=adresslist1?.get(0)?.longitude
        val loc2=Location("")
        loc2.latitude=lat1!!
        loc2.longitude=long1!!
        distance= (loc1.distanceTo(loc2)/1000).toInt().toDouble()
        val a= Intent(this@location,ChooseActivity::class.java)
        a.putExtra("distance",distance)
       startActivity(a)
    }


}