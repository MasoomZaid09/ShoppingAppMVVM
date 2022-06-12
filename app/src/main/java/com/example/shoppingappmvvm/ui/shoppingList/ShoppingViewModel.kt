package com.example.shoppingappmvvm.ui.shoppingList

import androidx.lifecycle.ViewModel
import com.example.shoppingappmvvm.data.db.models.ShoppingModelClass
import com.example.shoppingappmvvm.data.rsepositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsert(item :ShoppingModelClass) = CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)
    }

    fun delete(item :ShoppingModelClass) = CoroutineScope(Dispatchers.Main).launch{
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}