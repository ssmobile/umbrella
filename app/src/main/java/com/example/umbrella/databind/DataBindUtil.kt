package com.example.umbrella.databind

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.umbrella.model.forecastweatherresponse.ListItem
import com.example.umbrella.view.adapters.ForecastAdapter

@BindingAdapter("bind:data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, items : List<ListItem>) {
    if (recyclerView.adapter is ForecastAdapter) {
        (recyclerView.adapter as ForecastAdapter).setData(items)
    }
}
