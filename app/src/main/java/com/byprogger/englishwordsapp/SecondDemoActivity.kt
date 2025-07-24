package com.byprogger.englishwordsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.byprogger.englishwordsapp.databinding.ActivitySecondDemoBinding

class SecondDemoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, FirstDemoActivity::class.java)
            startActivity(intent)
        }

        val text = intent.getStringExtra("EXTRA_KEY_TEXT")
        val number = intent.getIntExtra("EXTRA_KEY_NUMBER", 0)

        with(binding) {

            tvValue1.text = text
            tvValue2.text = number.toString()

        }
    }
}