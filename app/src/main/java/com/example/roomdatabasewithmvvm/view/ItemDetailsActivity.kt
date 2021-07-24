package com.example.roomdatabasewithmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.roomdatabasewithmvvm.R
import kotlinx.android.synthetic.main.activity_item_details.*

class ItemDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        supportActionBar!!.hide()

        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val subTitle = intent.getStringExtra("subTitle")

        tvEntityTitle.text = title
        tvEntitySubTitle.text = subTitle

        Glide.with(applicationContext)
            .load(image)
            .into(ivEntityImage)
    }
}