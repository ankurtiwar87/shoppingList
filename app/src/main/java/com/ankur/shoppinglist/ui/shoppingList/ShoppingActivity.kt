package com.ankur.shoppinglist.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ankur.shoppinglist.R
import com.ankur.shoppinglist.data.db.ShoppingDatabase
import com.ankur.shoppinglist.data.db.entities.ShoppingItem
import com.ankur.shoppinglist.data.repositories.ShoppingRepository
import com.ankur.shoppinglist.databinding.ShoppingListBinding
import com.ankur.shoppinglist.others.ShoppingItemAdapter

class ShoppingActivity : AppCompatActivity() {

    private lateinit var binding: ShoppingListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ShoppingListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = ShoppingDatabase.getDatabase(this).getShoppingDao()
        val repository= ShoppingRepository(database)
        val viewModel= ViewModelProvider(this,ShoppingViewModelFactory(repository))[ShoppingViewModel::class.java]


        val adapter=ShoppingItemAdapter(ArrayList(), viewModel)
        binding.RecyclerView.adapter=adapter

        viewModel.getAllShoppingItem().observe(this, Observer {
                  adapter.updateItems(it as ArrayList<ShoppingItem>)
        })


        binding.floatingActionButton.setOnClickListener {
            AddShoppingDialogItem(this,object :AddShoppingDialogInterface{
                override fun onAddButtonClick(item: ShoppingItem) {
                    viewModel.upsert(item)
                }

            }).show()
        }
    }
}