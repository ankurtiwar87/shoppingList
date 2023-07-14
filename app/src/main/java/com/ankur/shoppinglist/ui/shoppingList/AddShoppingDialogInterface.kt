package com.ankur.shoppinglist.ui.shoppingList

import com.ankur.shoppinglist.data.db.entities.ShoppingItem

interface AddShoppingDialogInterface {

    fun onAddButtonClick(item: ShoppingItem)
}