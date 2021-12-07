package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.api.TextItemViewHolder

class AsteroidMainAdapter : RecyclerView.Adapter<TextItemViewHolder>(){

//    define data source
    var data = listOf<Asteroid>()
//    tell RecyclerView when data displaying has changed
//    setter updates field, set value in setter. call adapter method to tell recyclerView entire data set
//    may have changed and call recyclerView to redraw everything on screen
    set(value) {
        field = value
        notifyDataSetChanged()
    }

//    get size of data/amount of items that will be displayed on screen
    override fun getItemCount() = data.size

//    tell recyclerView how to actually draw an item
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
//        position that needs to be bound. so we look it up in data property
        val item = data[position]
//        viewHolder we provided has property called textView. we set the text displayed
//        by viewHolder. to finish adapter use asteroid codename
        holder.textView.text = item.codename
    }

//    tell RecyclerView how to create new viewHolder. API for that is onCreateViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
//        inflate layout from xml. create LayoutInflater from any group by passing context.
//        parent.context means create LayoutInflater from the parent view
        val layoutInflater = LayoutInflater.from(parent.context)
//        use layoutInflater object to inflate textItemView. Need to pass parent so layoutInflater
//        sets up view before parent passed. then attach TextView parent root
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
//        wrap view in holder and pass it back to RecyclerView. Call textItemViewHolder constructor and return object
        return TextItemViewHolder(view)
    }
}