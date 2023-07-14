package com.ankur.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ankur.shoppinglist.data.db.entities.ShoppingItem
import com.ankur.shoppinglist.ui.shoppingList.ShoppingActivity

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase :RoomDatabase() {
    abstract fun getShoppingDao(): shoppingDao
//    Companion Object is similar to the static in java in it we only want single instance of our database


    companion object {
        private var INSTANCE: ShoppingDatabase? = null
        fun getDatabase(context: Context): ShoppingDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context, ShoppingDatabase::class.java, "ShoppingDB.db").build()
                }
            }
            return INSTANCE!!
        }
    }

}
