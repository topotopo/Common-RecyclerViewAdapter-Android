package com.mmicu.demo

import android.app.Application
import com.mmicu.demo.di.appModule
import com.mmicu.demo.di.networkModule
import com.mmicu.demo.di.useCaseModule
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