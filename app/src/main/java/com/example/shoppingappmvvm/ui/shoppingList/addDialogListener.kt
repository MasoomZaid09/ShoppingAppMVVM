package com.example.shoppingappmvvm.ui.shoppingList

import com.example.shoppingappmvvm.data.db.models.ShoppingModelClass

interface addDialogListener {

    fun onAddButtonClick(item : ShoppingModelClass)
}