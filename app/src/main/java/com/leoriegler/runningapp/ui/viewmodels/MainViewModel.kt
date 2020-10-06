package com.leoriegler.runningapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.leoriegler.runningapp.repositories.MainRepository

class MainViewModel @ViewModelInject constructor(
    mainRepository: MainRepository
): ViewModel() {
}