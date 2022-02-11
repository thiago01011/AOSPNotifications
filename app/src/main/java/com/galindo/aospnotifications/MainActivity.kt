package com.galindo.aospnotifications

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setIconifiedByDefault(false)
        searchView.findViewById<ImageView>(R.id.search_close_btn).setOnClickListener {
            searchView.setQuery("", false)
            searchView.clearFocus()
        }

        val adapter = NotificationAdapter(this, NotificationDataList().loadNotifications())
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_notification)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        supportActionBar?.hide()
    }
}