package com.example.twomintnews
import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class NewApplication : Application() {
    override fun onCreate() {
        super.onCreate()

    }

    companion object{
        const val TAG = "NewApplication"
    }
}