package com.example.netflix_reboot

import android.app.Application
import com.example.netflix_reboot.container.AppContainer

class MyApplication : Application() {
    val applicationComponent : ApplicationComponent = DaggerApplicationComponent.create()
}