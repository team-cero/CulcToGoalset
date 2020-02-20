package com.example.culctogoalset

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.content.Intent
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // to get message from MainActivity
        val intent = getIntent()
        val distance = intent.extras?.getString(MainActivity.EXTRA_DISTANCE)?:""

        textView.text = distance

        button.setOnClickListener{
            val intentSub = Intent()


            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }

    }
}