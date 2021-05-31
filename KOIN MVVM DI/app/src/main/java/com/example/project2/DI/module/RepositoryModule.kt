package com.example.project2.DI.module

import com.example.project2.data.repository.MainRepository
import org.koin.dsl.module.module


val repoModule= module {
    single { MainRepository(get())
    }
}