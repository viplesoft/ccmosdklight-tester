package com.viplesoft.ccmosdktester

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.viplesoft.ccmosdk_light.CCMO
import com.viplesoft.ccmosdktester.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private lateinit var ccmo: CCMO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ccmo = CCMO("test_app", "akebalo")
        binding.btnOpenCcmo.setOnClickListener {
            ccmo.create(this)
        }

        onBackPressedDispatcher.addCallback(this) {
            finish()
        }
    }
}