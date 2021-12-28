package com.antonioleiva.architectcoderslite

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.antonioleiva.architectcoderslite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Toast.makeText(
                this,
                "user:${binding.user.text}, pass: ${binding.pass.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}