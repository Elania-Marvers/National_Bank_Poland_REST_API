package com.myiss.nationalbankofpolandrestapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class RecyclerViewAdapter(val rates: List<RateX>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val codeItem = itemView.findViewById<TextView>(R.id.code)
        val midItem = itemView.findViewById<TextView>(R.id.mid)
        val currencyItem = itemView.findViewById<TextView>(R.id.currency)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewItem = inflater.inflate(R.layout.item, parent, false)
        return ViewHolder(viewItem)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rate = rates[position]
        holder.codeItem.text = rate.code
        holder.currencyItem.text = rate.currency
        holder.midItem.text = rate.mid.toString()
    }


    override fun getItemCount(): Int {
        return rates.size
    }


}