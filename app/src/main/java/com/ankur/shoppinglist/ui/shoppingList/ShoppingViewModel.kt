package com.ankur.shoppinglist.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.ankur.shoppinglist.data.db.entities.ShoppingItem
import com.ankur.shoppinglist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


    class ShoppingViewModel(
        private val repository: ShoppingRepository
    ): ViewModel() {
        fun upsert(item: ShoppingItem)= CoroutineScope(Dispatchers.IO).launch {
            repository.upsert(item)
        }
        fun delete(item: ShoppingItem)= CoroutineScope(Dispatchers.IO).launch {
            repository.delete(item)
        }
        fun getAllShoppingItem()=repository.getAllShoppingItem()
    }