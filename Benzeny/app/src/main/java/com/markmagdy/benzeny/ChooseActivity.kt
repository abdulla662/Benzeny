package com.markmagdy.benzeny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ChooseActivity : AppCompatActivity() {
    private lateinit var benzenetype: Spinner
    lateinit var carcon: Spinner
    lateinit var cc: Spinner
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var gotolocation: Button
    private lateinit var calc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        benzenetype = findViewById(R.id.benzenetype)
        carcon = findViewById(R.id.carcon)
        cc = findViewById(R.id.CC)
        gotolocation = findViewById(R.id.gotolocation)
        calc = findViewById(R.id.calc)

        var distance = intent.getDoubleExtra("distance", 0.0).toInt()

        val condition = arrayOf("Perfect Condition", "Good Condition", "Bad Condition")
        val types = arrayOf("Benzene 92", "Benzene 95")
        val cece = arrayOf(
            "1000cc", "1200cc", "1300cc", "1400cc", "1500cc",
            "1600cc", "1800cc", "2000cc"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            types
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        benzenetype.adapter = adapter

        val adapter1 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            condition
        )
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        carcon.adapter = adapter1

        val adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            cece
        )
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        cc.adapter = adapter2

        cc.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                calc.setOnClickListener {
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 0) {
                        val value=0.043
                        //val value=20
                        val lit = distance * 1.05*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 0) {
                        val value=0.043
                        val lit = distance * 1.05*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 0) {
                        val value=0.043
                        val lit = distance * 1.1*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 0) {
                        val value=0.043
                        val lit = distance * 1.1*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 0) {
                        val value=0.043
                        val lit = distance * 1.15*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 0) {
                        val value=0.043
                        val lit = distance * 1.15*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 1) {
                        val value=0.0485
                        val lit = distance * 1.05*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 1) {
                        val value=0.0485
                        val lit = distance * 1.05*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 1) {
                        val value=0.0485
                        val lit = distance * 1.1*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 1) {
                        val value=0.0485
                        val lit = distance * 1.1*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 1) {
                        val value=0.0485
                        val lit = distance * 1.15*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 1) {
                        val value=0.0485
                        val lit = distance * 1.15*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 2) {
                        val value=0.05
                        val lit = distance * 1.05*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 2) {
                        val value=0.05
                        val lit = distance * 1.05*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 2) {
                        val value=0.05
                        val lit = distance * 1.1*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 2) {
                        val value=0.05
                        val lit = distance * 1.1*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 2) {
                        val value=0.05
                        val lit = distance * 1.15*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 2) {
                        val value=0.05
                        val lit = distance * 1.15*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 3) {
                        val value=0.057
                        val lit = distance * 1.05*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 3) {
                        val value=0.057
                        val lit = distance * 1.05*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 3) {
                        val value=0.057
                        val lit = distance * 1.1*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 3) {
                        val value=0.057
                        val lit = distance * 1.1*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 3) {
                        val value=0.057
                        val lit = distance * 1.15*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 3) {
                        val value=0.057
                        val lit = distance * 1.15*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 4) {
                        val value=0.0595
                        val lit = distance * 1.05*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 4) {
                        val value=0.0595
                        val lit = distance * 1.05*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 4) {
                        val value=0.0595
                        val lit = distance * 1.1*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 4) {
                        val value=0.0595
                        val lit = distance * 1.1*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 4) {
                        val value=0.0595
                        val lit = distance * 1.15*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 4) {
                        val value=0.0595
                        val lit = distance * 1.15*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 5) {
                        val value=0.069
                        val lit = distance * 1.05*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 5) {
                        val value=0.069
                        val lit = distance * 1.05*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 5) {
                        val value=0.069
                        val lit = distance * 1.1*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 5) {
                        val value=0.069
                        val lit = distance * 1.1*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 5) {
                        val value=0.069
                        val lit = distance * 1.15*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 5) {
                        val value=0.069
                        val lit = distance * 1.15*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 6) {
                        val value=0.0755
                        val lit = distance * 1.05*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 6) {
                        val value=0.0755
                        val lit = distance * 1.05*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 6) {
                        val value=0.0755
                        val lit = distance * 1.1*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 6) {
                        val value=0.0755
                        val lit = distance * 1.1*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 6) {
                        val value=0.0755
                        val lit = distance * 1.15*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 6) {
                        val value=0.0755
                        val lit = distance * 1.15*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 7) {
                        val value=0.082
                        val lit = distance * 1.05*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 7) {
                        val value=0.082
                        val lit = distance * 1.05*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 7) {
                        val value=0.082
                        val lit = distance * 1.1*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 7) {
                        val value=0.082
                        val lit = distance * 1.1*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 7) {
                        val value=0.082
                        val lit = distance * 1.15*value
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 7) {
                        val value=0.082
                        val lit = distance * 1.15*value
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@ChooseActivity, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    this@ChooseActivity,
                    "Please choose a category",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun locations(view: View) {
        val intent = Intent(this, location::class.java)
        startActivity(intent)
    }
}
