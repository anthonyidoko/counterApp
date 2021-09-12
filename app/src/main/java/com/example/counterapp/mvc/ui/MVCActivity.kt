package com.example.counterapp.mvc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.counterapp.R
import com.example.counterapp.databinding.ActivityMvcactivityBinding

class MVCActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvcactivityBinding
    lateinit var count :MutableLiveData<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        count = MutableLiveData(0)

        count.observe(this,{
            binding.tvCount.text = it.toString()
        })

        binding.btnAdd.setOnClickListener {
            count.value = count.value?.plus(1)

        }

        binding.btnClear.setOnClickListener {
            count.value = 0

        }
    }

    private fun increaseCount(){
        count.value = count.value?.plus(1)
    }

    private fun clearCount(){
        count.value = 0
    }
}