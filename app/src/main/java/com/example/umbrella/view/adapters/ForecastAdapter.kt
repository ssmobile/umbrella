package com.example.umbrella.view.adapters

import android.annotation.SuppressLint
import android.icu.text.Edits
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.umbrella.R
import com.example.umbrella.model.forecastweatherresponse.ListItem
import kotlinx.android.synthetic.main.forecast_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.Comparator

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    lateinit var itemsList : List<List<ListItem>>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.forecast_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = itemsList.size

    fun setData(items : List<List<ListItem>>) {
        itemsList = items
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SimpleDateFormat")
        fun bind(item: List<ListItem>?) {
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            val date = format.parse(item!![0].dtTxt)
            val dayOfWeek = SimpleDateFormat("E").format(date)
            val temps = ArrayList<Double>()
            val hours = ArrayList<String>()
            var max = 0.0
            var min = 1000.0

            for (i in item) {
                if (i.main?.temp!! > max) { max = i.main.temp }
                if (i.main.temp < min) { min = i.main.temp }
                temps.add(i.main.temp)
                hours.add(i.dtTxt?.substring(11,16)!!)
            }

            itemView.dayOfWeek.text = dayOfWeek
            itemView.minTemp.text = min.toString()
            itemView.maxTemp.text = max.toString()



        }
    }

}