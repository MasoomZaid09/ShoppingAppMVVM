package com.example.shoppingappmvvm.ui.shoppingList

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingappmvvm.data.db.ShoppingDatabase
import com.example.shoppingappmvvm.data.db.models.ShoppingModelClass
import com.example.shoppingappmvvm.data.rsepositories.ShoppingRepository
import com.example.shoppingappmvvm.databinding.ActivityShoppingBinding
import com.example.shoppingappmvvm.other.ShoppingItemAdapter
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.util.*

class ShoppingActivity : AppCompatActivity() , KodeinAware {

    override val kodein by kodein()
    private val factory : viewModelfactory by instance()

    private lateinit var binding : ActivityShoppingBinding

//    lateinit var recyclerView: RecyclerView
//    lateinit var fab: FloatingActionButton
    lateinit var adapter: ShoppingItemAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        adapter = ShoppingItemAdapter(listOf(), viewModel)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer{
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {

            addShoppingItemDialog(this,
            object : addDialogListener{
                override fun onAddButtonClick(item: ShoppingModelClass) {
                    viewModel.upsert(item)

                }
            }).show()
        }

    }

}