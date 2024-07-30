package com.frogobox.minimummvvm.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.databinding.ActivityMainBinding
import com.frogobox.minimummvvm.util.RvListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RvListener {

    private val viewModel: MainViewModel by viewModels()

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
        viewModel.apply {
            setupData()
            mainData.observe(this@MainActivity) {
                setupRV(it)
            }
        }
    }

    private fun setupRV(it: MutableList<ContactModel>) {
        mainAdapter.setContent(it)
        binding.rv.apply {
            adapter = mainAdapter
            layoutManager =
                GridLayoutManager(this@MainActivity, 2)
        }
    }

    override fun onClickListener(data: ContactModel) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
    }

}