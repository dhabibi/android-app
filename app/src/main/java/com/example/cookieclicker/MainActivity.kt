package com.example.cookieclicker

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.cookieclicker.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var cookieCount: Long = 0
    private var cookiesPerClick: Long = 1
    private var autoClickerCount: Int = 0
    private var autoClickerCost: Long = 10
    private var doubleClickCost: Long = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateUI()
        setupClickListeners()
        startAutoClicker()
    }

    private fun setupClickListeners() {
        binding.cookieButton.setOnClickListener {
            cookieCount += cookiesPerClick
            animateCookie(it)
            showClickFeedback()
            updateUI()
        }

        binding.buyAutoClicker.setOnClickListener {
            if (cookieCount >= autoClickerCost) {
                cookieCount -= autoClickerCost
                autoClickerCount++
                autoClickerCost = (autoClickerCost * 1.5).toLong()
                updateUI()
            }
        }

        binding.buyDoubleClick.setOnClickListener {
            if (cookieCount >= doubleClickCost) {
                cookieCount -= doubleClickCost
                cookiesPerClick *= 2
                doubleClickCost = (doubleClickCost * 2.5).toLong()
                updateUI()
            }
        }
    }

    private fun animateCookie(view: View) {
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.9f, 1f)
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.9f, 1f)

        AnimatorSet().apply {
            playTogether(scaleX, scaleY)
            duration = 100
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }
    }

    private fun showClickFeedback() {
        binding.clickFeedback.apply {
            text = "+${formatNumber(cookiesPerClick)}"
            alpha = 1f
            translationY = 0f

            animate()
                .alpha(0f)
                .translationY(-100f)
                .setDuration(500)
                .start()
        }
    }

    private fun startAutoClicker() {
        binding.root.postDelayed(object : Runnable {
            override fun run() {
                if (autoClickerCount > 0) {
                    cookieCount += autoClickerCount
                    updateUI()
                }
                binding.root.postDelayed(this, 1000)
            }
        }, 1000)
    }

    private fun updateUI() {
        binding.cookieCount.text = getString(R.string.cookie_count, formatNumber(cookieCount))
        binding.cookiesPerClick.text = getString(R.string.per_click, formatNumber(cookiesPerClick))
        binding.cookiesPerSecond.text = getString(R.string.per_second, autoClickerCount)

        binding.buyAutoClicker.apply {
            text = getString(R.string.buy_auto_clicker, formatNumber(autoClickerCost))
            isEnabled = cookieCount >= autoClickerCost
            alpha = if (isEnabled) 1f else 0.5f
        }

        binding.buyDoubleClick.apply {
            text = getString(R.string.buy_double_click, formatNumber(doubleClickCost))
            isEnabled = cookieCount >= doubleClickCost
            alpha = if (isEnabled) 1f else 0.5f
        }

        binding.autoClickerCount.text = getString(R.string.auto_clickers_owned, autoClickerCount)
    }

    private fun formatNumber(number: Long): String {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(number)
    }
}
