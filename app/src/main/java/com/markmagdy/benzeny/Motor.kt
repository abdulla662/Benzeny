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

class Motor : AppCompatActivity() {
    private lateinit var benzenetype: Spinner
    lateinit var carcon: Spinner
    lateinit var cc: Spinner
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var gotolocation: Button
    private lateinit var calc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motor)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        benzenetype = findViewById(R.id.benzenetype)
        carcon = findViewById(R.id.carcon)
        cc = findViewById(R.id.CC)
        gotolocation = findViewById(R.id.gotolocation)
        calc = findViewById(R.id.calc)

        var distance = intent.getDoubleExtra("distance", 0.0).toInt()

        // Updated arrays to include "Please select" as the first, unselectable option
        val condition =
            arrayOf("Please select", "Perfect Condition", "Good Condition", "Bad Condition")
        val types = arrayOf("Please select", "Benzene 92", "Benzene 95")
        val cece = arrayOf(
            "Please select", "150cc", "200cc", "300cc", "350cc", "400cc",
            "450cc", "600cc", "800cc", "1000cc"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            types
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            benzenetype.adapter = this
        }

        val adapter1 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            condition
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            carcon.adapter = this
        }

        val adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            cece
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            cc.adapter = this
        }


        benzenetype.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (position == 0) {
                    Toast.makeText(this@Motor, "Please select a valid option", Toast.LENGTH_SHORT).show()
                    benzenetype.setSelection(1) // Reset selection to first item

                } else {
                    calc.isEnabled = true
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Toast.makeText(this@Motor, "Please make a selection", Toast.LENGTH_SHORT).show()
            }
        }
        carcon.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (position == 0) { // Assuming 'Please select' is at position 0
                    Toast.makeText(this@Motor, "Please select a valid option", Toast.LENGTH_SHORT).show()
                    carcon.setSelection(1)

                } else {
                    calc.isEnabled = true
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Toast.makeText(this@Motor, "Please make a selection", Toast.LENGTH_SHORT).show()
            }
        }
        cc.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (position == 0) { // Assuming 'Please select' is at position 0
                    Toast.makeText(this@Motor, "Please select a valid option", Toast.LENGTH_SHORT).show()
                    cc.setSelection(1)

                } else {
                    calc.isEnabled = true
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Toast.makeText(this@Motor, "Please make a selection", Toast.LENGTH_SHORT).show()
            }
        }



        cc.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            )
            {
                calc.setOnClickListener {
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 0) {

                        val lit = distance * 1.05*0.027
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 0) {
                        val lit = distance * 1.05*0.027
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 0) {
                        val lit = distance * 1.1*0.027
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 0) {
                        val lit = distance * 1.1*0.027
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 0) {
                        val lit = distance * 1.15*0.027
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 0) {
                        val lit = distance * 1.15*0.027
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 1) {
                        val lit = distance * 1.05*0.027
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 1) {
                        val lit = distance * 1.05*0.027
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 1) {
                        val lit = distance * 1.1*0.027
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 1) {
                        val lit = distance * 1.1*0.027
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 1) {
                        val lit = distance * 1.15*0.027
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 1) {
                        val lit = distance * 1.15*0.027
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 2) {
                        val lit = distance * 1.05*0.031
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 2) {
                        val lit = distance * 1.05*0.031
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 2) {
                        val lit = distance * 1.1*0.031
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 2) {
                        val lit = distance * 1.1*0.031
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 2) {
                        val lit = distance * 1.15*0.031
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 2) {
                        val lit = distance * 1.15*0.031
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 3) {
                        val lit = distance * 1.05*0.031
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 3) {
                        val lit = distance * 1.05*0.031
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 3) {
                        val lit = distance * 1.1*0.031
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 3) {
                        val lit = distance * 1.1*0.031
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 3) {
                        val lit = distance * 1.15*0.031
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 3) {
                        val lit = distance * 1.15*0.031
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 4) {
                        val lit = distance * 1.05*0.036
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 4) {
                        val lit = distance * 1.05*0.036
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 4) {
                        val lit = distance * 1.1*0.036
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 4) {
                        val lit = distance * 1.1*0.036
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 4) {
                        val lit = distance * 1.15*0.036
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 4) {
                        val lit = distance * 1.15*0.036
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 5) {
                        val lit = distance * 1.05*0.036
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 5) {
                        val lit = distance * 1.05*0.036
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 5) {
                        val lit = distance * 1.1*0.036
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 5) {
                        val lit = distance * 1.1*0.036
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 5) {
                        val lit = distance * 1.15*0.036
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 5) {
                        val lit = distance * 1.15*0.036
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 6) {
                        val lit = distance * 1.05*0.043
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 6) {
                        val lit = distance * 1.05*0.043
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 6) {
                        val lit = distance * 1.1*0.043
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 6) {
                        val lit = distance * 1.1*0.043
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 6) {
                        val lit = distance * 1.15*0.043
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 6) {
                        val lit = distance * 1.15*0.043
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 7) {
                        val lit = distance * 1.05*0.049
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 7) {
                        val lit = distance * 1.05*0.049
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 7) {
                        val lit = distance * 1.1*0.049
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 7) {
                        val lit = distance * 1.1*0.049
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 7) {
                        val lit = distance * 1.15*0.049
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 7) {
                        val lit = distance * 1.15*0.049
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 0 && position == 8) {
                        val lit = distance * 1.05*0.051
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 0 && position == 8) {
                        val lit = distance * 1.05*0.051
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 1 && position == 8) {
                        val lit = distance * 1.1*0.051
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 1 && position == 8) {
                        val lit = distance * 1.1*0.051
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor,
                            "Your benzene consumption is $lit L, estimated price is $price EGP, and the distance is $dis km",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 0 && carcon.selectedItemPosition == 2 && position == 8) {
                        val lit = distance * 1.15*0.051
                        val price = lit * 12.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }
                    if (benzenetype.selectedItemPosition == 1 && carcon.selectedItemPosition == 2 && position == 8) {
                        val lit = distance * 1.15*0.051
                        val price = lit * 13.5
                        val dis = distance
                        Toast.makeText(
                            this@Motor, "Your benzene consumption is $lit L, " +
                                    "estimated price is $price EGP, " +
                                    "and the distance is $dis km", Toast.LENGTH_LONG
                        ).show()
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    this@Motor,
                    "Please choose a category",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun locations(view: View) {
        val intent = Intent(this, Location2::class.java)
        startActivity(intent)
    }
}
