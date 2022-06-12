package com.example.shoppingappmvvm.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppingappmvvm.R
import com.example.shoppingappmvvm.data.db.models.ShoppingModelClass
import com.example.shoppingappmvvm.databinding.DialogAddShoppingItemsBinding

class addShoppingItemDialog(
    context : Context,
    var addDialogListener: addDialogListener
) : AppCompatDialog(context) {


    private lateinit var binding: DialogAddShoppingItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){

                Toast.makeText(context, "Please enter all the information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingModelClass(name , amount.toInt())
            addDialogListener.onAddButtonClick(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener {
            cancel()
        }

    }
}