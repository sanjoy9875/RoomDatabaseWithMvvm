package com.example.roomdatabasewithmvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.roomdatabasewithmvvm.R
import com.github.ybq.android.spinkit.SpinKitView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val splashTimeOut :Int = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        spin_kit.visibility = View.VISIBLE

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, ShowItemActivity::class.java)
            startActivity(intent)
            finish()
            spin_kit.visibility = View.GONE

        }, splashTimeOut.toLong())

    }
}