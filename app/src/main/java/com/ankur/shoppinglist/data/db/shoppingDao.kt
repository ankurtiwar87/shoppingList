package com.ankur.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ankur.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface shoppingDao {
    @Insert
    fun upsert(item: ShoppingItem)
    @Delete
    fun delete(item: ShoppingItem)
   @Query("SELECT * FROM Shopping_Item")
   fun getAllShoppingData():LiveData<List<ShoppingItem>>

}