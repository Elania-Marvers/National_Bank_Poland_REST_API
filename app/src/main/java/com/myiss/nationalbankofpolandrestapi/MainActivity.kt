package com.myiss.nationalbankofpolandrestapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var card: RecyclerView
    lateinit var data: Beans
    lateinit var adapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        card = findViewById<RecyclerView>(R.id.listview)
        card.layoutManager = LinearLayoutManager(this)
        findViewById<Button>(R.id.refresh).setOnClickListener { refreshthis() }
    }

    private fun refreshthis() {

        thread {
            try {
                data = RequestUtils.getBeans()
                adapter = RecyclerViewAdapter(data[0].rates)

                for (e in data) {
                    for (j in e.rates) {
                        Log.i("ELIE", "code: " + j.code + " mid: " + j.mid + " currency: " + j.currency)
                    }
                }


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        Thread.sleep(1000)
        card.adapter = adapter

    }


}

