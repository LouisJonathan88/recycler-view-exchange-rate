// Terakhir dikerjakan: Sabtu, 17 Mei 2025
// NIM: 10122362
// Nama: Louis Jonathan Susanto Putra
// Kelas: Pemrograman Android 4

package com.example.recyclerviewexchangerate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexchangerate.adapter.ExchangeRateAdapter
import com.example.recyclerviewexchangerate.model.ExchangeRate

class MainActivity : AppCompatActivity() {

    private lateinit var rvExchangeRate: RecyclerView
    private lateinit var adapter: ExchangeRateAdapter
    private val list = mutableListOf<ExchangeRate>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvExchangeRate = findViewById(R.id.rv_exchange_rate)
        rvExchangeRate.setHasFixedSize(true)
        rvExchangeRate.layoutManager = LinearLayoutManager(this)

        list.addAll(getListOfExchangeRate())
        adapter = ExchangeRateAdapter(list)
        rvExchangeRate.adapter = adapter
    }

    private fun getListOfExchangeRate(): List<ExchangeRate> {
        val names = resources.getStringArray(R.array.data_name)
        val buys = resources.getStringArray(R.array.data_buy)
        val sells = resources.getStringArray(R.array.data_sell)
        val flags = resources.obtainTypedArray(R.array.data_gambar)

        val exchangeList = mutableListOf<ExchangeRate>()
        for (i in names.indices) {
            val exchangeRate = ExchangeRate(
                country = names[i],
                buy = buys[i],
                sell = sells[i],
                flag = flags.getResourceId(i, -1)
            )
            exchangeList.add(exchangeRate)
        }

        flags.recycle()
        return exchangeList
    }
}
