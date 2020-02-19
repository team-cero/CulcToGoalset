package com.example.culctogoalset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.ColorSpace
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // variables
    companion object{
        const val EXTRA_BRAND = "com.example.kotlinactivitydatatrans.BRAND"
        const val EXTRA_MODEL = "com.example.kotlinactivitydatatrans.MODEL"
        const val EXTRA_FUEL = "com.example.kotlinactivitydatatrans.FUEL"
        const val EXTRA_DISTANCE = "com.example.kotlinactivitydatatrans.DISTANCE"
    }

    // initializations
    //spinners
    private val blandItems = arrayOf("Alfa Romeo", "BMW", "TOYOTA")
    var selectedBrand: String = "Alfa Romeo"

    private val modelItems = arrayOf("147 1.9", "Brera 2.2", "GT 2.0")
    var selectedModel: String = "147 1.9"

    private val fuelItems = arrayOf("Biodiesel", "Diesel","Petrol")
    var selectedFuel: String = "Biodiesel"

    //form
    private val DISTANCE = 1000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //spinners
        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val spinner3 = findViewById<Spinner>(R.id.spinner3)

        // ArrayAdapter
        val adapter1 = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, blandItems)
        val adapter2 = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, modelItems)
        val adapter3 = ArrayAdapter(applicationContext,
            android.R.layout.simple_spinner_item, fuelItems)

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //set adapters to spinners
        spinner1.adapter = adapter1
        spinner2.adapter = adapter2
        spinner3.adapter = adapter3

        //register listeners
        //Bland
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //　when the item was selected
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                // Kotlin Android Extensions
                selectedBrand = item
            }
            //if the item was not selected
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        //Model
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //　when the item was selected
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                // Kotlin Android Extensions
                selectedModel = item
            }
            //if the item was not selected
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        //Fuel
        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            //　when the item was selected
            override fun onItemSelected(parent: AdapterView<*>?,
                                        view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String
                // Kotlin Android Extensions
                selectedFuel= item
            }
            //if the item was not selected
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        }

        /*
        //move to the sub page once the culc button was tapped
        button.setOnClickListener{
            if (distance.text != null){
            val intent = Intent(applicationContext, SubActivity::class.java)
            val str = distance.text.toString()
            val brand_result = selectedBrand
            val model_result = selectedModel
            val fuel_result = selectedFuel
            Log.d("debug", str)

            intent.putExtra(EXTRA_BRAND, brand_result)
            intent.putExtra(EXTRA_MODEL,model_result)
            intent.putExtra(EXTRA_FUEL, fuel_result)
            intent.putExtra(EXTRA_DISTANCE, str)
            startActivityForResult(intent, DISTANCE)
                distance.setText("")
            }
        }

         */

    }
}
