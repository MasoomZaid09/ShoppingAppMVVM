package com.example.shoppingappmvvm.data.rsepositories

import android.content.Context
import com.example.shoppingappmvvm.data.db.ShoppingDatabase
import com.example.shoppingappmvvm.data.db.models.ShoppingModelClass

class ShoppingRepository(

    private val db: ShoppingDatabase = ShoppingDatabase.instance!!
)
{

    suspend fun upsert(item : ShoppingModelClass) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingModelClass) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()

}