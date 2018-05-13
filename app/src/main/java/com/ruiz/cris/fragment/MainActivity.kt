package com.ruiz.cris.fragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentOnLoaded = true
    val manager = supportFragmentManager
    private lateinit var btnChange : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnChange = findViewById(R.id.btn_change)


        showFragmentOne()
        btnChange.setOnClickListener({
            if(isFragmentOnLoaded)
                showFragmentTwo()
            else
                showFragmentOne()
        })
    }

    fun showFragmentOne(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentOne()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOnLoaded = true
    }

    fun showFragmentTwo(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentTwo()
        transaction.replace(R.id.fragment_holder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentOnLoaded = false
    }
}
