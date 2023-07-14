package com.ankur.shoppinglist.others

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ankur.shoppinglist.R
import com.ankur.shoppinglist.data.db.entities.ShoppingItem
import com.ankur.shoppinglist.databinding.ShoppingItemBinding
import com.ankur.shoppinglist.ui.shoppingList.ShoppingViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoppingItemAdapter(private val list :ArrayList<ShoppingItem>,private val mainViewModel:ShoppingViewModel):
 RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>(){


     inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
     {
         val binding=ShoppingItemBinding.bind(itemView)
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateItems(newList:ArrayList<ShoppingItem>)
    {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentItem = list[position]
        holder.binding.textView.text=currentItem.name
        holder.binding.textView2.text="${currentItem.amount}"

        holder.binding.imageView.setOnClickListener {
            GlobalScope.launch (Dispatchers.Main){
                mainViewModel.delete(currentItem)

            }
        }

        holder.binding.imageView2.setOnClickListener{
            currentItem.amount++
            GlobalScope.launch (Dispatchers.Main) {

                mainViewModel.upsert(currentItem)
            }
        }

        holder.binding.imageView3.setOnClickListener {
            if (currentItem.amount>0) {
                currentItem.amount--
                GlobalScope.launch (Dispatchers.Main) {
                    mainViewModel.upsert(currentItem)
                }
            }
        }
    }
}