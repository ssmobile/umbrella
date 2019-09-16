package com.example.umbrella.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.umbrella.R
import com.example.umbrella.model.forecastweatherresponse.ListItem
import kotlinx.android.synthetic.main.forecast_item.view.*

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {

    var itemsList = emptyList<ListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.forecast_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(itemsList[position])

    override fun getItemCount(): Int = itemsList.size

    fun setData(items : List<ListItem>) {
        itemsList = items
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item : ListItem) {
            itemView.forecastTV.text = "$item"
        }
    }



}