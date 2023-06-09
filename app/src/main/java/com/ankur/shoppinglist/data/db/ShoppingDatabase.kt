package com.ankur.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ankur.shoppinglist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class]
        , version = 1
)
abstract class ShoppingDatabase:RoomDatabase() {

    abstract  fun getShoppingDao(): shoppingDao
//    Companion Object is similar to the static in java in it we only want single instance of our database
    companion object{
        @Volatile
        private var instance: ShoppingDatabase?= null

    private val LOCK= Any()

    operator fun invoke(context: Context)= instance ?:synchronized(LOCK){
        instance ?: createDatabase(context).also { instance =it }
    }

    private  fun createDatabase(context:Context)=
           Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java,"ShoopingDB.db").build()
    }
}