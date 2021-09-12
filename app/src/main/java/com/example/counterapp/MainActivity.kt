package com.example.counterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.counterapp.databinding.ActivityMainBinding
import com.example.counterapp.mvc.ui.MVCActivity
import com.example.counterapp.mvvm.ui.MVVMActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListenerOnButtons(binding.btnMVC)
        setClickListenerOnButtons(binding.btnMVVM)

    }

    private fun setClickListenerOnButtons(btn :Button){
        btn.setOnClickListener {
            if (btn == binding.btnMVVM){
                val intent = Intent(this, MVVMActivity::class.java )
                startActivity(intent)
            }else{
                val intent = Intent(this, MVCActivity::class.java )
                startActivity(intent)
            }
        }

    }
}