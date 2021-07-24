package com.example.roomdatabasewithmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShowItemActivity : AppCompatActivity() ,OnItemClick{

    private lateinit var viewModel: EntityViewModel
    private lateinit var adapter:EntityAdapter
    private var entityList = mutableListOf<ResponseEntity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_item)

        supportActionBar!!.hide()

        /**
         * shimmer effects starts here
         **/
        shimmerFrameLayout.visibility = View.VISIBLE
        shimmerFrameLayout.startShimmer()

        /**
         * pass a empty-list to the adapter
         **/
        adapter = EntityAdapter(entityList,this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        /**
         * creating a view-model object to access the methods of view-model
         * */
        val appObj = application as EntityApplication
        val repository = appObj.repository
        val viewModelFactory = EntityViewmodelFactory(repository)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                            .get(EntityViewModel::class.java)


        /**calling getEntity() & observing the live data here to get the data from Room-Database
         * after getting the data I stop shimmer-effect here
         * then I add the data to our list & called notifyDataSetChanged()
         **/
        viewModel.getEntity().observe(this, Observer {
            shimmerFrameLayout.visibility = View.GONE
            shimmerFrameLayout.stopShimmer()
            recyclerView.visibility = View.VISIBLE
            entityList.clear()
            entityList.addAll(it)
            adapter.notifyDataSetChanged()

        })

        /**
         * define a coroutine to get response from API
         **/
        CoroutineScope(Dispatchers.IO).launch {
                viewModel.getResponse()
        }


        /**
         * adding a textChangedListener to the EditText for search our itemList
         * */
        etSearchItem.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {

             filter(s.toString().toLowerCase())
            }
        })
    }

    /**
     * This method will filter the searched item & add filtered item into a new list
     * Then this new list will pass to the adapter via filteredList() method
     **/
    fun filter(text : String){
        var tempList = mutableListOf<ResponseEntity>()
        entityList.forEach {
            if (it.title.toLowerCase().contains(text)){
                tempList.add(it)
            }
        }
        adapter.filteredList(tempList)
    }

    /**
     * when you clicked any particular item this function will pass all data related
     * to that item & open a new activity
     */
    override fun onEntityItemClicked(position: Int) {
        val intent = Intent(this,ItemDetailsActivity::class.java)
        intent.putExtra("image",entityList[position].image)
        intent.putExtra("title",entityList[position].title)
        intent.putExtra("subTitle",entityList[position].subTitle)
        startActivity(intent)
    }

}