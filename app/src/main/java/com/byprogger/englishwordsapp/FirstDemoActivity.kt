package com.byprogger.englishwordsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.byprogger.englishwordsapp.databinding.ActivityFirstDemoBinding

class FirstDemoActivity: AppCompatActivity() {

    private lateinit var binding: ActivityFirstDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener {
            val intent = Intent(this, SecondDemoActivity::class.java)
            intent.putExtra("EXTRA_KEY_TEXT", "Don't panic just passing")
            intent.putExtra("EXTRA_KEY_NUMBER", 99)
            startActivity(intent)
        }
    }

}