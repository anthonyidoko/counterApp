package com.example.counterapp.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass :ViewModel() {

    val currentCount  = MutableLiveData(0)

}