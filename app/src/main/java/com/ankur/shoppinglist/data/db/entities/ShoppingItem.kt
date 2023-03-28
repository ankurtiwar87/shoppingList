package com.ankur.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Shopping_Item")
data class ShoppingItem(
    @ColumnInfo(name="item_name")
    var name : String,
    @ColumnInfo(name="item_amount")
    var amount :Int
){
//    We here don't want to generate id our self that's why we don't pass this in our constructor
    @PrimaryKey(autoGenerate = true)
    var id :Int?=null
}