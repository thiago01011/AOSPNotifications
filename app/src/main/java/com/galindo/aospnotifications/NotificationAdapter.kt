package com.galindo.aospnotifications

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class NotificationAdapter(
    private val context: Context,
    private val list: List<NotificationData>,
) : RecyclerView.Adapter<NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification_list, parent, false)
        return NotificationViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notificationData = list[position]
        if (position == 0)
            holder.card.setOnClickListener {
                startActivity(context,
                              Intent(context, NotificationSettings::class.java),
                       null)
            }
        else
            holder.card.setOnClickListener {
                var isChecked = holder.switch.isChecked
                holder.switch.isChecked = !isChecked
            }
        holder.textViewDescription.text = notificationData.description
        holder.textViewTitle.text = notificationData.type
        holder.icon.setImageResource(notificationData.icon)

    }

    override fun getItemCount(): Int = list.size
}

class NotificationViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view) {
    val card: CardView
    val textViewTitle: TextView
    val textViewDescription: TextView
    var icon: ImageView
    var switch: SwitchCompat
    init {
        // Define click listener for the ViewHolder's View.
        card = view.findViewById(R.id.card_notification)
        //card.setOnClickListener { /*startActivity(context, Intent(context, NotificationSettings::class.java), null)*/ }
        textViewTitle = view.findViewById(R.id.notification_title)
        textViewDescription = view.findViewById(R.id.notification_description)
        icon = view.findViewById(R.id.ic_notification)
        switch = view.findViewById(R.id.switch1)
    }
}
