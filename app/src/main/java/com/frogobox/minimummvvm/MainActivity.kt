package com.frogobox.minimummvvm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.frogobox.minimummvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainItemListener {

    private val mainViewModel: MainViewModel by viewModels()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val mainAdapter = MainAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViewModel()
    }

    private fun setupViewModel() {
        mainViewModel.apply {
            setupData()
            mainData.observe(this@MainActivity) {
                setupRV(it)
            }
        }
    }

    private fun setupRV(it: MutableList<MainData>) {
        mainAdapter.setContent(it)
        binding.rvFrogo.apply {
            adapter = mainAdapter
            layoutManager =
                GridLayoutManager(this@MainActivity, 2)
        }
    }

    override fun onClickListener(data: MainData) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
    }

}