package com.example.broadcastsendingdata

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendBroadcastButton(view: View) {
        Intent(this, BroadcastInnerClass::class.java).also {
            val bundle = Bundle()
            bundle.putString("name", "James")
            bundle.putInt("age", 50)
            bundle.putString("instrument", "Guitar")
            it.putExtras(bundle)
            sendBroadcast(it)
        }
    }

    class BroadcastInnerClass : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent != null) {
                val bundle = intent.extras
                if (bundle != null) {
                    val myString = bundle.getString("name")
                    val myInt = bundle.getInt("age")
                    val myString2 = bundle.getString("instrument")

                    Toast.makeText(context, "name: $myString, age: $myInt, instrument: $myString2", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}