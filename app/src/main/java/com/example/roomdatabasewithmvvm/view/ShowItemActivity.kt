package com.example.roomdatabasewithmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabasewithmvvm.R
import com.example.roomdatabasewithmvvm.adapter.EntityAdapter
import com.example.roomdatabasewithmvvm.adapter.OnItemClick
import com.example.roomdatabasewithmvvm.data.models.ResponseEntity
import com.example.roomdatabasewithmvvm.viewmodel.EntityViewModel
import com.example.roomdatabasewithmvvm.viewmodel.EntityViewmodelFactory
import kotlinx.android.synthetic.main.activity_show_item.*

class ShowItemActivity : AppCompatActivity() ,OnItemClick{

    private lateinit var viewModel: EntityViewModel
    var entityList = mutableListOf<ResponseEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_item)

        supportActionBar!!.hide()

        val adapter = EntityAdapter(entityList,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        val appObj = application as EntityApplication
        val repository = appObj.repository

        val viewModelFactory = EntityViewmodelFactory(repository)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(EntityViewModel::class.java)


        viewModel.getResponse().observe(this, Observer {
            val response = it
            entityList.clear()
            entityList.addAll(response)
            viewModel.addEntity(entityList)

        })

        viewModel.getEntity().observe(this, Observer {
            entityList.clear()
            entityList.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }

    override fun onEntityItemClicked(position: Int) {
        val intent = Intent(this,ItemDetailsActivity::class.java)
        intent.putExtra("image",entityList[position].image)
        intent.putExtra("title",entityList[position].title)
        intent.putExtra("subTitle",entityList[position].subTitle)
        startActivity(intent)
    }

}