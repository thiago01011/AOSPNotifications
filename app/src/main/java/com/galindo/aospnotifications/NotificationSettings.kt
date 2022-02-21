package com.galindo.aospnotifications

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NotificationSettings : AppCompatActivity() {


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_settings)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, SettingsFragment())
            .commit()

//        val items = listOf("Option 1", "Option 2", "Option 3", "Option 4")
//        val adapter = ArrayAdapter(this, R.layout.item_importance_menu, items)
//        val textField = findViewById<TextInputLayout>(R.id.menu_importance)
//        (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    //populateImportanceSpinner()
    }

//    fun populateImportanceSpinner() {
//        val spinner: Spinner = findViewById(R.id.spinner_importance)
//
//        // Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.importance_array,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }
//    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    companion object {
        const val KEY_PREF_ONGOING = "ongoing"
    }
}
