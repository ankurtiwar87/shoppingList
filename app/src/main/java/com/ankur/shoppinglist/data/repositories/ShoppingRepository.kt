package com.ankur.shoppinglist.data.repositories

import android.view.animation.OvershootInterpolator
import androidx.lifecycle.LiveData
import com.ankur.shoppinglist.data.db.ShoppingDatabase
import com.ankur.shoppinglist.data.db.entities.ShoppingItem
import com.ankur.shoppinglist.data.db.shoppingDao

class ShoppingRepository(private val shoppingDao: shoppingDao){

    suspend fun upsert(item: ShoppingItem)
    {
        shoppingDao.upsert(item)
    }
     suspend fun delete(item:ShoppingItem)
    {
        shoppingDao.delete(item)
    }
    fun getAllShoppingItem():LiveData<List<ShoppingItem>>
    {
        return shoppingDao.getAllShoppingData()
    }


}