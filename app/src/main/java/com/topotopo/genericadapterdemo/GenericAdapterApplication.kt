package com.topotopo.genericadapterdemo

import android.app.Application
import com.topotopo.genericadapterdemo.di.appModule
import com.topotopo.genericadapterdemo.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GenericAdapterApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@GenericAdapterApplication)
            modules(appModule)
            modules(networkModule)
        }
    }
}