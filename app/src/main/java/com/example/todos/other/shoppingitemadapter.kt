package com.example.todos.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todos.R
import com.example.todos.data.Shoppingitem
import com.example.todos.ui.shoppinglist.shoppingviewmodel
import kotlinx.android.synthetic.main.shopping_item.view.*


class ShoppingItemAdapter(
    var items: List<Shoppingitem>,
    private val viewModel: shoppingviewmodel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.tvname.text = curShoppingItem.name
        holder.itemView.tvamount.text = "${curShoppingItem.amount}"

        holder.itemView.ivdelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivplus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.ivminus.setOnClickListener {
            if(curShoppingItem.amount > 0) {
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }

        }
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}
