package com.topotopo.demo

import android.app.Application
import com.topotopo.demo.di.appModule
import com.topotopo.demo.di.networkModule
import com.topotopo.demo.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DemoApplication)
            modules(listOf(appModule, networkModule, useCaseModule))
        }
    }
}