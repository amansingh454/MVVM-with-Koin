package com.example.project2.DI.module

import com.example.project2.data.network.MovieApi
import org.koin.dsl.module.module


val appModule= module {
    single { MovieApi }
}
