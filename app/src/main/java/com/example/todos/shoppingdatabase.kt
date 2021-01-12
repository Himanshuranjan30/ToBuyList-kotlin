package com.example.todos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = [Shoppingitem::class],
version = 1
    )
abstract class ShoppingDatabase:RoomDatabase() {
    abstract fun getshoppingdao():shoppingdao

    companion object{
        @Volatile
        private var instance:ShoppingDatabase?=null
        private  val LOCK=Any()
        operator fun invoke(context: Context)=instance?: synchronized(LOCK){
         instance?: createdatabase(context).also { instance=it }
        }
        private fun createdatabase(context: Context)=
            Room.databaseBuilder(context.applicationContext,ShoppingDatabase::class.java,"shoppingDB.db").build()
    }
}