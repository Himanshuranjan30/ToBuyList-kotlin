package com.example.todos

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface shoppingdao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Shoppingitem)

    @Delete
    suspend fun delete(item: Shoppingitem)

    @Query("SELECT * FROM shopping_items")
    suspend fun getallshoppingitems():LiveData<List<Shoppingitem>>
}