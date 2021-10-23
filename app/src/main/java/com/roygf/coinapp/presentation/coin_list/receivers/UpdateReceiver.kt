package com.roygf.coinapp.presentation.coin_list.receivers

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.roygf.coinapp.presentation.coin_list.view_model.CoinListViewModel

class UpdateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, inIntent: Intent?) {
        val intent = Intent(context, UpdateService::class.java)
        context?.startService(intent)
        setAlarm(context)
    }

    fun setAlarm(context: Context?) {
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, UpdateReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0)
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            (System.currentTimeMillis() / 1000L + 15L) * 1000L,
            pendingIntent
        )
    }
}