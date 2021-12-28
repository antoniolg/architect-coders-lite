package com.antonioleiva.architectcoderslite

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.antonioleiva.architectcoderslite.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.progress.visibility = View.GONE

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                binding.button.visibility = View.GONE
                binding.progress.visibility = View.VISIBLE
                tryLogin(binding.user.text.toString(), binding.pass.text.toString())

                binding.button.visibility = View.VISIBLE
                binding.progress.visibility = View.GONE
            }
        }
    }

    private suspend fun tryLogin(user: String, pass: String) {
        delay(2000)
        Toast.makeText(
            this,
            "user:${user}, pass: ${pass}",
            Toast.LENGTH_SHORT
        ).show()
    }
}