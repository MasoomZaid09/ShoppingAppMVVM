package com.example.shoppingappmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppingappmvvm.data.db.models.ShoppingModelClass

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingModelClass)

    @Delete
    suspend fun delete(item: ShoppingModelClass)

    @Query("SELECT * FROM Shopping_Items")
    fun getAllShoppingItems() : LiveData<List<ShoppingModelClass>>

}