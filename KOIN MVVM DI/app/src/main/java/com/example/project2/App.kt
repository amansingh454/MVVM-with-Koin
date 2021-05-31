package com.example.project2

import android.app.Application
import com.example.project2.DI.module.ViewModelModule
import com.example.project2.DI.module.appModule
import com.example.project2.DI.module.repoModule
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class App :Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, repoModule, ViewModelModule))

}}