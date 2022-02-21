package com.galindo.aospnotifications

class NotificationDataList {
    fun loadNotifications(): List<NotificationData> = listOf (
        NotificationData(
            type = "General notifications",
            description = "Notifications that can be customized as you wish.",
            icon = R.drawable.ic_general_notification),
        NotificationData(
            type = "Media notifications",
            description = "Notifications related to Radio and Spotify app.",
            icon = R.drawable.ic_media_notification),
        NotificationData(
            type = "Call notifications",
            description = "Notifications related to Dialer and Google dialer app.",
            icon = R.drawable.ic_call_notification),
        NotificationData(
            type = "Missed call notification",
            description = "Notifications related to a missed call notification from Dialer or Google Dialer.",
            icon = R.drawable.ic_missed_call_notification),
        NotificationData(
            type = "Conversation notifications",
            description = "Notifications related to Messaging, Hangouts, Whatsapp, and telegram app.",
            icon = R.drawable.ic_sms_notification),
        NotificationData(
            type = "Scheduled notifications",
            description = "Notifications related to Calendar and Alarm app.",
            icon = R.drawable.ic_scheduled_notification),
        NotificationData(
            type = "Email notifications",
            description = "Notifications related to Gmail and Outlook app.",
            icon = R.drawable.ic_email_notification),
        NotificationData(
            type = "Social media notifications",
            description = "Notifications related to Twitter, Youtube, Facebook, and Instagram app.",
            icon = R.drawable.ic_social_media_notification)
    )
}