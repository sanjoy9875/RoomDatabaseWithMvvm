package com.example.roomdatabasewithmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.roomdatabasewithmvvm.R
import com.example.roomdatabasewithmvvm.models.ResponseEntity
import com.example.roomdatabasewithmvvm.remote.APIService
import com.example.roomdatabasewithmvvm.remote.Resource
import com.example.roomdatabasewithmvvm.remote.ResponseHandler
import com.example.roomdatabasewithmvvm.remote.RetrofitGenerator
import com.example.roomdatabasewithmvvm.viewmodel.EntityViewModel
import com.example.roomdatabasewithmvvm.viewmodel.EntityViewmodelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show_item.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowItemActivity : AppCompatActivity() {

    private lateinit var viewModel: EntityViewModel
    var entityList = mutableListOf<ResponseEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_item)


        val appObj = application as EntityApplication
        val repository = appObj.repository

        val viewModelFactory = EntityViewmodelFactory(repository)

        viewModel  = ViewModelProviders.of(this, viewModelFactory)
            .get(EntityViewModel::class.java)


            btnClick.setOnClickListener {

                CoroutineScope(Dispatchers.IO).launch {
                    val image = "https://hood-cdn.nobrokerhood.com/8a96a18479087a610179091454db20c2/rental_agreement/1626422824181_group_buying.png"
                    val title = "Title 1"
                    val subTitle = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

                    val newEntity = ResponseEntity(image, title, subTitle)
                    entityList.add(newEntity)

                    viewModel.addEntity(entityList)
                }
            }

    }

}