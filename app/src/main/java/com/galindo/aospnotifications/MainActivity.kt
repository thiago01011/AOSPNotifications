package com.galindo.aospnotifications

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView


class MainActivity : AppCompatActivity() {

    lateinit var generalNotificationCard: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var generalNotificationCard = findViewById<MaterialCardView>(R.id.notification_basic)
//        generalNotificationCard.setOnClickListener {
//            ContextCompat.startActivity(
//                this,
//                Intent(this, NotificationSettings::class.java),
//                null
//            )
//        }

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
        PreferenceManager.setDefaultValues(this, R.xml.root_preferences, false)

        retrieveSharedPreferenceValues()
    }

    fun retrieveSharedPreferenceValues() {
        val sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val switchPref = sharedPref.getBoolean(NotificationSettings.KEY_PREF_ONGOING, false)
        Toast.makeText(
            this, switchPref.toString(),
            Toast.LENGTH_SHORT
        ).show()

    }
}