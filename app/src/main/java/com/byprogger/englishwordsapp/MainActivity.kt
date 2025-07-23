package com.byprogger.englishwordsapp

import android.graphics.Color
import android.os.Bundle
import android.os.CpuUsageInfo
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.byprogger.englishwordsapp.databinding.ActivityLearnWordBinding
import com.byprogger.englishwordsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityLearnWordBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("Binding for ActivityMainBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLearnWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layoutAnswer3.setOnClickListener{
            markAnswerCorrect()
        }

        binding.layoutAnswer1.setOnClickListener{
            markAnswerWrong()
        }

        binding.btnContinue.setOnClickListener{
            markAnswerNeutral()
        }

    }

    private fun markAnswerNeutral() {
        with(binding) {
            for (layout in listOf(layoutAnswer1, layoutAnswer3)) {
                layout.background = ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.shape_rounded_containers
                )
            }

            for (textView in listOf(tvVariantValue1, tvVariantValue3)) {
                textView.setTextColor(
                    ContextCompat.getColor(
                        this@MainActivity,
                        R.color.textVariantColor,
                    )
                )
            }

            for (textView in listOf(tvVariantNumber1, tvVariantNumber3)) {
                textView.apply {
                    setTextColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.textVariantColor
                        )
                    )

                    background = ContextCompat.getDrawable(
                        this@MainActivity,
                        R.drawable.shape_rounded_variants
                    )
                }
            }

            layoutResult.isVisible = false
            btnSkip.isVisible = true
        }
    }

    private fun markAnswerWrong() {
        binding.layoutAnswer1.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_wrong
        )

        binding.tvVariantNumber1.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_wrong,
        )

        binding.tvVariantNumber1.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white,
            )
        )

        binding.tvVariantValue1.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongColor,
            )
        )

        binding.btnSkip.isVisible = false

        binding.layoutResult.setBackgroundColor(
            ContextCompat.getColor(this@MainActivity, R.color.wrongColor)
        )

        binding.ivResultIcon.setImageDrawable(
            ContextCompat.getDrawable(
                this@MainActivity, R.drawable.ic_wrong,
            )
        )

        binding.tvResultMessage.text = resources.getString(R.string.title_wrong)

        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.wrongColor,
            )
        )

        binding.layoutResult.isVisible = true
    }

    private fun markAnswerCorrect() {
        binding.layoutAnswer3.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_correct
        )

        binding.tvVariantNumber3.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_correct,
        )

        binding.tvVariantNumber3.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white,
            )
        )

        binding.tvVariantValue3.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctColor,
            )
        )

        binding.btnSkip.isVisible = false

        binding.layoutResult.setBackgroundColor(
            ContextCompat.getColor(this@MainActivity, R.color.correctColor)
        )

        binding.ivResultIcon.setImageDrawable(
            ContextCompat.getDrawable(
                this@MainActivity, R.drawable.ic_correct,
            )
        )

        binding.tvResultMessage.text = resources.getString(R.string.title_correct)

        binding.btnContinue.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctColor,
            )
        )

        binding.layoutResult.isVisible = true
    }
}