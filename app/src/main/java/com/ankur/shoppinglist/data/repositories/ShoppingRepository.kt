package com.ankur.shoppinglist.data.repositories

import android.view.animation.OvershootInterpolator
import com.ankur.shoppinglist.data.db.ShoppingDatabase
import com.ankur.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db :ShoppingDatabase
){

    suspend fun upsert(item:ShoppingItem)=db.getShoppingDao().upsert(item)
    suspend fun delete(item:ShoppingItem)=db.getShoppingDao().delete(item)
    fun getAllShoppingItem()=db.getShoppingDao().getAllShoppingData()


}