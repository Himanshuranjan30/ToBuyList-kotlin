package com.example.todos.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todos.data.repositories.ShoppingRepo

@Suppress("UNCHECKED_CAST")
class shoppingviewmodelfactory(private val repository:ShoppingRepo):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return shoppingviewmodel(repository) as T
    }
}