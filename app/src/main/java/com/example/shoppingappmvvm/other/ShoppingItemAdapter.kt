package com.example.shoppingappmvvm.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingappmvvm.R
import com.example.shoppingappmvvm.data.db.models.ShoppingModelClass
import com.example.shoppingappmvvm.ui.shoppingList.ShoppingViewModel

class ShoppingItemAdapter(
    var items : List<ShoppingModelClass>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_items, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItems = items[position]

        holder.tvName.text = currentShoppingItems.name
        holder.tvAmount.text = "${currentShoppingItems.ammount}"

        holder.imgDelete.setOnClickListener {
            viewModel.delete(currentShoppingItems)
        }

        holder.imgPlus.setOnClickListener {
            currentShoppingItems.ammount++
            viewModel.upsert(currentShoppingItems)
        }

        holder.imgMinus.setOnClickListener {
            if (currentShoppingItems.ammount > 0){
                currentShoppingItems.ammount--
                viewModel.upsert(currentShoppingItems)
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val tvName :TextView = itemView.findViewById(R.id.tvName)
        val tvAmount :TextView = itemView.findViewById(R.id.tvAmount)
        val imgDelete :ImageView = itemView.findViewById(R.id.ivDelete)
        val imgMinus :ImageView = itemView.findViewById(R.id.ivMinus)
        val imgPlus :ImageView = itemView.findViewById(R.id.ivPlus)
    }

}