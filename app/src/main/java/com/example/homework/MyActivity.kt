package com.example.homework

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyActivity: AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    private val adapter = MyAdapter()

    companion object {
        const val COUNT_KEY = "COUNT_KEY"
    }

    private var count = 5
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        fab = findViewById(R.id.fab)
        recyclerView.adapter = adapter
        fab.setOnClickListener {
            adapter.addItem(adapter.itemCount + 1)
        }
        if (savedInstanceState != null)
        {
            count = savedInstanceState.getInt(COUNT_KEY)
            for (i in 1..count)
            {
                adapter.addItem(i)
            }
        } else {
            adapter.setItems(listOf(1, 2, 3, 4, 5))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, adapter.itemCount)
    }
}