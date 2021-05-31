package com.example.project2.DI.module

import androidx.lifecycle.ViewModel
import com.example.project2.UI.MOVIES.ViewModel.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val ViewModelModule= module {
        viewModel {
                MainViewModel(get())
        }


        }

