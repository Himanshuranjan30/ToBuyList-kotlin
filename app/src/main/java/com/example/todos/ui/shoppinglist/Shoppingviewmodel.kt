package com.example.todos.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.todos.data.Shoppingitem
import com.example.todos.data.repositories.ShoppingRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class shoppingviewmodel(private  val repository:ShoppingRepo):ViewModel() {

    fun upsert(item:Shoppingitem)= CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item) }

    fun delete(item: Shoppingitem)= CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)

    }
    fun getallitems()= repository.getallitems()
}