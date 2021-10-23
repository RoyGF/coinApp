package com.roygf.coinapp.presentation.coin_list.receivers

import android.app.Service
import android.content.Intent
import android.os.HandlerThread
import android.os.IBinder
import android.os.Process
import android.widget.Toast
import com.roygf.coinapp.presentation.coin_list.view_model.CoinListViewModel

class UpdateService : Service() {

    override fun onCreate() {
        val thread = HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_FOREGROUND)
        thread.start()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}