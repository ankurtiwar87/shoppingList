package com.ankur.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ankur.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface shoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun upsert(item: ShoppingItem)
    @Delete
    suspend fun delete(item: ShoppingItem)
   @Query("SELECT * FROM Shopping_Item")
   fun getAllShoppingData():LiveData<List<ShoppingItem>>

}