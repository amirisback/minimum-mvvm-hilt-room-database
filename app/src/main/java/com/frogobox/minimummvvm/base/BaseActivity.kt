package com.frogobox.minimummvvm.base

import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by faisalamircs on 31/07/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    val startActivityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            setupOnActivityResult(it)
        }

    protected val binding: VB by lazy {
        setupViewBinding()
    }

    abstract fun setupViewBinding(): VB

    abstract fun setupUI()

    abstract fun setupViewModel()

    open fun setupOnActivityResult(activityResult: ActivityResult) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupUI()
        setupViewModel()
    }

}