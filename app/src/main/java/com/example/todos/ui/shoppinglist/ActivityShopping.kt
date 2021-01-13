package com.example.todos.ui.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.todos.R
import com.example.todos.data.db.ShoppingDatabase
import com.example.todos.data.repositories.ShoppingRepo

class ActivityShopping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database=ShoppingDatabase(this)
        val repo=ShoppingRepo(database)
        val factory=shoppingviewmodelfactory(repo)

        val viewmodel= ViewModelProviders.of(this,factory).get(shoppingviewmodel::class.java)
    }
}