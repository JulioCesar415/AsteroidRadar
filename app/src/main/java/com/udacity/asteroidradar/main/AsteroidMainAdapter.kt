package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.api.TextItemViewHolder
import com.udacity.asteroidradar.database.DatabaseEntities

//Adapter object acts as a bridge between an AdapterView and underlying data for that
//view. The Adapter provides access to the data items. Adapter is also responsible for
//making a View for each item in the data set. Builds views for ListView or GridView
class AsteroidMainAdapter : RecyclerView.Adapter<AsteroidMainAdapter.ViewHolder>(){

//    define data source
    var data = listOf<DatabaseEntities>()
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
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        position that needs to be bound. so we look it up in data property
        val item = data[position]

        val res = holder.itemView.context.resources
//        viewHolder we provided has property called textView. we set the text displayed
//        by viewHolder. to finish adapter use asteroid codename
        holder.codename.text =
        holder.textView.text = item.codename

    }

//    ViewHolder will display the list of asteroids
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        hold reference to views this ViewHolder will update
//        reference to asteroid codename
        val codename: TextView = itemView.findViewById(R.id.codename_TextView)
//        reference to asteroid approach date
        val closeApproachDate: TextView = itemView.findViewById(R.id.approach_date_TextView)
//        reference to asteroid hazardous ImageView
        val hazardousImageView: ImageView = itemView.findViewById(R.id.hazardous_ImageView)

    }

//    tell RecyclerView how to create new viewHolder. API for that is onCreateViewHolder.
//    onCreateViewHolder is called whenever RecyclerView needs new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        inflate layout from xml. create LayoutInflater from any group by passing context.
//        parent.context means create LayoutInflater from the parent view
        val layoutInflater = LayoutInflater.from(parent.context)
//        use layoutInflater object to inflate textItemView. Need to pass parent so layoutInflater
//        sets up view before parent passed. then attach TextView parent root
        val view = layoutInflater.inflate(R.layout.asteroid_item, parent, false)
//        wrap view in holder and pass it back to RecyclerView. Call textItemViewHolder constructor and return object
        return ViewHolder(view)
    }
}