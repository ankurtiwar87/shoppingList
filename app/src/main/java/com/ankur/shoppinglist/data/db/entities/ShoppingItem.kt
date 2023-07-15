package com.ankur.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Shopping_Item")
data class ShoppingItem(



    var name : String,
    var amount :Int
)
{
    @PrimaryKey(autoGenerate = true)
    var id :Int?=null
}
