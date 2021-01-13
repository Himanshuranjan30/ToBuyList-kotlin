package com.example.todos.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todos.R
import com.example.todos.data.Shoppingitem
import com.example.todos.data.db.ShoppingDatabase
import com.example.todos.data.repositories.ShoppingRepo
import com.example.todos.other.ShoppingItemAdapter
import kotlinx.android.synthetic.main.activity_shopping.*

class ActivityShopping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repo = ShoppingRepo(database)
        val factory = shoppingviewmodelfactory(repo)

        val viewmodel = ViewModelProviders.of(this, factory).get(shoppingviewmodel::class.java)
        val adapter = ShoppingItemAdapter(listOf(), viewmodel)

        rvshoppingitems.layoutManager = LinearLayoutManager(this)
        rvshoppingitems.adapter = adapter

        viewmodel.getallitems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            addshoppingitemdialog(
                this,
                object : adddialoglistener {

                    override fun onbuttonclicked(item: Shoppingitem) {
                        viewmodel.upsert(item)
                    }
                }).show()
        }
    }
}
