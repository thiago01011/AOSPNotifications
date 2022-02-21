package com.galindo.aospnotifications

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

//        return CourseViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val notificationData = list[position]
        if (position == 0)
            holder.card.setOnClickListener {
                startActivity(context,
                              Intent(context, NotificationSettings::class.java),
                       null)
            }
        holder.textViewDescription.text = notificationData.description
        holder.textViewTitle.text = notificationData.type
        holder.icon.setImageResource(notificationData.icon)
        //bind(notificationData, onItemClickListener)
    //      val course = list[position]
//      holder.bind(course, onItemClickListener)
//        holder.binding.apply {
//            textviewCourseName.text = list[position].name
//            textviewCourseBrand.text = list[position].numberOfClasses.toString()
//            imageviewCoursePic.setImageResource(list[position].imageCourse)
//        }
//        holder.itemView.setOnClickListener { onItemClickListener.onClick(list[position]) }
    }

    override fun getItemCount(): Int = list.size
}

class NotificationViewHolder(view: View, context: Context): RecyclerView.ViewHolder(view) {
    val card: CardView
    val textViewTitle: TextView
    val textViewDescription: TextView
    var icon: ImageView
    init {
        // Define click listener for the ViewHolder's View.
        card = view.findViewById(R.id.card_notification)
        //card.setOnClickListener { /*startActivity(context, Intent(context, NotificationSettings::class.java), null)*/ }
        textViewTitle = view.findViewById(R.id.notification_title)
        textViewDescription = view.findViewById(R.id.notification_description)
        icon = view.findViewById(R.id.ic_notification)
    }


//    fun bind(course: Course, onItemClickListener: ItemClickListener) {
//        view.apply {
//            setOnClickListener { onItemClickListener.onClick(course) }
//            findViewById<ImageView>(R.id.imageview_course_pic).setImageResource(course.imageCourse)
//            findViewById<TextView>(R.id.textview_course_name).text = course.name
//            findViewById<TextView>(R.id.textview_course_brand).text = course.numberOfClasses.toString()
//        }
//    }
}
//
//fun interface ItemClickListener {
//    fun onClick(course: Course)
//}

//private val onItemClickListener: ItemClickListener

