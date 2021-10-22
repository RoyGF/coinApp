package com.roygf.coinapp.core

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

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