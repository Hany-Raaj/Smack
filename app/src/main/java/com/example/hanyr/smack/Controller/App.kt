package com.example.hanyr.smack.Controller

import android.app.Application
import com.example.hanyr.smack.Utilities.SharedPrefs

/**
 * Created by Hanyr on 22-Jan-18.
 */
class App: Application() {

    companion object {
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        prefs = SharedPrefs(applicationContext)
        super.onCreate()
    }
}