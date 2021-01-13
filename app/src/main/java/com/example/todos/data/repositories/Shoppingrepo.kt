package com.example.todos.data.repositories

import com.example.todos.data.Shoppingitem
import com.example.todos.data.db.ShoppingDatabase

class ShoppingRepo(private  val db:ShoppingDatabase) {

    suspend fun upsert(item:Shoppingitem)=db.getshoppingdao().upsert(item)
    suspend fun delete(item: Shoppingitem)=db.getshoppingdao().delete(item)
    fun getallitems()=db.getshoppingdao().getallshoppingitems()
}