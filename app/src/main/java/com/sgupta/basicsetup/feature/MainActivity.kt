package com.sgupta.basicsetup.feature

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.sgupta.basicsetup.feature.fragments.HomeFragment
import com.sgupta.setup.R
import com.sgupta.setup.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_activity_main_layout, HomeFragment.newInstance())
            .commit()
    }
}