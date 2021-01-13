package com.example.todos.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todos.data.Shoppingitem

@Dao
interface shoppingdao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Shoppingitem)

    @Delete
    suspend fun delete(item: Shoppingitem)

    @Query("SELECT * FROM shopping_items")
    fun getallshoppingitems():LiveData<List<Shoppingitem>>
}