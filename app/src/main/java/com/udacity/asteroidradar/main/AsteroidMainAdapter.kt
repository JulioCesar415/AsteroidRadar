package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.database.DatabaseEntities
import com.udacity.asteroidradar.databinding.AsteroidItemBinding

//Adapter object acts as a bridge between an AdapterView and underlying data for that
//view. The Adapter provides access to the data items. Adapter is also responsible for
//making a View for each item in the data set. Builds views for ListView or GridView
class AsteroidMainAdapter : ListAdapter<DatabaseEntities, AsteroidMainAdapter.ViewHolder>(AsteroidDiffCallback()){

//    tell recyclerView how to actually draw an item
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        position that needs to be bound. so we look it up in data property
        val item = getItem(position)

//        viewHolder we provided has property called textView. we set the text displayed
//        by viewHolder. to finish adapter use asteroid codename
        holder.bind(item)
}


    //    ViewHolder will display the list of asteroids
    class ViewHolder private constructor(val binding: AsteroidItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(
            item: DatabaseEntities,
        ) {
            binding.databaseEntities = item
            binding.executePendingBindings()
//            val res = itemView.context.resources
//                //        hold reference to views this ViewHolder will update
////        reference to asteroid codename
//            binding.codenameTextView.text = item.codename
//                //        reference to asteroid approach date
//            binding.approachDateTextView.text = item.closeApproachDate
//                //        reference to asteroid hazardous ImageView
//            binding.hazardousImageView.setImageResource(
//                when (item.isPotentiallyHazardous) {
//                    true -> R.drawable.ic_status_potentially_hazardous
//                    else -> R.drawable.ic_status_normal
//                }
//            )
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = AsteroidItemBinding.inflate(layoutInflater, parent, false)
                //        wrap view in holder and pass it back to RecyclerView. Call textItemViewHolder constructor and return object
                return ViewHolder(binding)
            }
        }
    }

//    tell RecyclerView how to create new viewHolder. API for that is onCreateViewHolder.
//    onCreateViewHolder is called whenever RecyclerView needs new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        inflate layout from xml. create LayoutInflater from any group by passing context.
//        parent.context means create LayoutInflater from the parent view
//        use layoutInflater object to inflate textItemView. Need to pass parent so layoutInflater
//        sets up view before parent passed. then attach TextView parent root
        return ViewHolder.from(parent)
    }

}
//this class will help by checking two list and comparing them to each other. AsteroidDiffCallback
//will only make the necessary changes needed to redraw items on the screen. This makes it more efficient
class AsteroidDiffCallback: DiffUtil.ItemCallback<DatabaseEntities>(){
    override fun areItemsTheSame(oldItem: DatabaseEntities, newItem: DatabaseEntities): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DatabaseEntities, newItem: DatabaseEntities): Boolean {
        return oldItem == newItem
    }
}