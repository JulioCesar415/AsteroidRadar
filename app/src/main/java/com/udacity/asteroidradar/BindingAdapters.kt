package com.udacity.asteroidradar

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.room.Database
import com.udacity.asteroidradar.database.DatabaseEntities

@BindingAdapter("statusIcon")
fun bindAsteroidStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.ic_status_potentially_hazardous)
    } else {
        imageView.setImageResource(R.drawable.ic_status_normal)
    }
}

@BindingAdapter("asteroidStatusImage")
fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
    if (isHazardous) {
        imageView.setImageResource(R.drawable.asteroid_hazardous)
    } else {
        imageView.setImageResource(R.drawable.asteroid_safe)
    }
}

@BindingAdapter("astronomicalUnitText")
fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
}

@BindingAdapter("kmUnitText")
fun bindTextViewToKmUnit(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_unit_format), number)
}

@BindingAdapter("velocityText")
fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
    val context = textView.context
    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
}

@BindingAdapter("asteroidName")
fun TextView.setAsteroidName(item: DatabaseEntities?){
    item?.let {
        text = item.codename.toString()
    }
}

@BindingAdapter("dateApproach")
fun TextView.setApproachDate(item: DatabaseEntities?){
    item?.let {
        text = item.closeApproachDate.toString()
    }
}

@BindingAdapter("imageHazardous")
fun ImageView.setImageHazardous(item: DatabaseEntities?){
    item?.let {
        setImageResource(when (item.isPotentiallyHazardous){
            true -> R.drawable.ic_status_potentially_hazardous
            else -> R.drawable.ic_status_normal
        })
    }
}
