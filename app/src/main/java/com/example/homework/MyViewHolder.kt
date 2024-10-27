package com.example.homework

import android.annotation.SuppressLint
import android.content.res.Resources
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView


class MyViewHolder(view: View):RecyclerView.ViewHolder(view) {

    val text = view.findViewById<TextView>(R.id.text_1)
    val imageView = view.findViewById<ImageView>(R.id.image_view)

    @SuppressLint("ResourceAsColor")
    fun bind(number: Int) {
        text.text = "$number"
        if (number % 2 == 0) {
            imageView.setBackgroundResource(R.color.red)
        } else {
            imageView.setBackgroundResource(R.color.blue)
        }
    }
}