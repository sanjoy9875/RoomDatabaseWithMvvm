package com.example.roomdatabasewithmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabasewithmvvm.R

class ItemDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val subTitle = intent.getStringExtra("subTitle")
    }
}