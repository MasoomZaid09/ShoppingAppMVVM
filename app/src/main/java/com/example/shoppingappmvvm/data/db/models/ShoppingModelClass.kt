package com.example.shoppingappmvvm.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Shopping_Items")
data class ShoppingModelClass (

    @ColumnInfo(name = "item_name")
    val name : String,

    @ColumnInfo(name = "item_ammount")
    var ammount : Int
){
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}