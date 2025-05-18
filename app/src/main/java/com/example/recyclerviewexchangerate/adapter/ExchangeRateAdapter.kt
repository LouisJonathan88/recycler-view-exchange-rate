package com.example.recyclerviewexchangerate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexchangerate.R
import com.example.recyclerviewexchangerate.model.ExchangeRate

class ExchangeRateAdapter(private val exchangeList: List<ExchangeRate>) :
    RecyclerView.Adapter<ExchangeRateAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivFlag: ImageView = view.findViewById(R.id.ivCountryFlag)
        val tvCountry: TextView = view.findViewById(R.id.tvCountry)
        val tvBuy: TextView = view.findViewById(R.id.tvBuy)
        val tvSell: TextView = view.findViewById(R.id.tvSell)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_exchange, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = exchangeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = exchangeList[position]
        holder.ivFlag.setImageResource(item.flag)
        holder.tvCountry.text = item.country
        holder.tvBuy.text = item.buy
        holder.tvSell.text = item.sell
    }
}
