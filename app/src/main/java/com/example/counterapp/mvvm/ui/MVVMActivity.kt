package com.example.counterapp.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.counterapp.databinding.ActivityMvvmactivityBinding
import com.example.counterapp.mvvm.ui.viewmodel.ViewModelClass
import kotlinx.coroutines.Dispatchers

class MVVMActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmactivityBinding
    private lateinit var viewModel :ViewModelClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //viewModel instance
        viewModel = ViewModelProvider(this)[ViewModelClass::class.java]

        //Observe current count
        viewModel.currentCount.observe(this, {
            binding.tvCount.text = it.toString()
        })

        //Set click listener on btnAdd
        binding.btnAdd.setOnClickListener {
            increaseCount()
        }

        //Set click listener on btnAdd
        binding.btnClear.setOnClickListener {
            clearCount()
        }
    }


    private fun increaseCount(){
        val count = viewModel.currentCount
        count.value = count.value?.plus(1)
    }

    private fun clearCount(){
        val count = viewModel.currentCount
        count.value = 0
    }
}