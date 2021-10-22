package com.roygf.coinapp.core

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.roygf.coinapp.R
import java.text.NumberFormat

@BindingAdapter("coinImage")
fun loadImage(imageView: ImageView, imagePath: String?) {
    imagePath.let {
        Glide.with(imageView.context)
            .load(it)
            .into(imageView)
    }
}

@BindingAdapter("textValue")
fun loadText(textView: TextView, text: String?) {
    if (text != null) {
        textView.text = text
    } else {
        textView.text = "No text available"
    }
}

@BindingAdapter("priceText")
fun loadPriceText(textView: TextView, value: Double?) {
    if (value != null) {

        val numberFormat = NumberFormat.getCurrencyInstance()
        numberFormat.maximumIntegerDigits = 1000000000
        numberFormat.maximumFractionDigits = 2
        val convert = numberFormat.format(value)

        textView.text = convert
    } else {
        textView.text = "No value available"
    }
}

@BindingAdapter("favIcon")
fun loadIcon(floatingActionButton: FloatingActionButton, favorite: Boolean) {
    if(favorite) {
        floatingActionButton.setImageResource(R.drawable.ic_favorite_selected)
    } else{
        floatingActionButton.setImageResource(R.drawable.ic_favorite_unselected)
    }
}