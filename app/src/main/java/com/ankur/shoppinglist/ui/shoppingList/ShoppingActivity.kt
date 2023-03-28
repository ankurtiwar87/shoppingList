package com.ankur.shoppinglist.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.ankur.shoppinglist.R
import com.ankur.shoppinglist.data.db.ShoppingDatabase
import com.ankur.shoppinglist.data.repositories.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_list)

        val database = ShoppingDatabase(this)
        val repository= ShoppingRepository(database)
        val factory =ShoppingViewModelFactory(repository)
        val viewModel= ViewModelProviders.of(this,factory)[ShoppingViewModel::class.java]
    }
}