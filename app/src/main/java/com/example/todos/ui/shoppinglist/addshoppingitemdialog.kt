package com.example.todos.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import androidx.core.R
import com.example.todos.data.Shoppingitem
import kotlinx.android.synthetic.main.dialog_add_item.*
import kotlinx.android.synthetic.main.shopping_item.*

class addshoppingitemdialog(context: Context,var addlistener:adddialoglistener):AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.todos.R.layout.dialog_add_item)
        tvAdd.setOnClickListener{
            val name=etName.text.toString()
            val amount=etAmount.text.toString()
            if(name.isEmpty()||amount.isEmpty())
            {
                Toast.makeText(context,"Please enter all the information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item=Shoppingitem(name,amount.toInt())
            addlistener.onbuttonclicked(item)
            dismiss()

        }
        tvCancel.setOnClickListener{
            cancel()
        }
    }
}