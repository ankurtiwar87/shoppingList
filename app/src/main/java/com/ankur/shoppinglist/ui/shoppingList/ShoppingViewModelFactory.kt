package com.ankur.shoppinglist.ui.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ankur.shoppinglist.data.repositories.ShoppingRepository

class ShoppingViewModelFactory(private val  repository: ShoppingRepository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository)as T
    }

}