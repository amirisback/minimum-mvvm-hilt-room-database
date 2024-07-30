package com.frogobox.minimummvvm.ui.contact

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.frogobox.minimummvvm.base.BaseActivity
import com.frogobox.minimummvvm.databinding.ActivityContactBinding
import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.ui.editor.EditorActivity
import com.frogobox.minimummvvm.util.Resource
import com.frogobox.minimummvvm.util.RvListener
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by faisalamircs on 30/07/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


@AndroidEntryPoint
class ContactActivity : BaseActivity<ActivityContactBinding>(), RvListener {

    private val viewModel: ContactViewModel by viewModels()

    private val contactAdapter = ContactViewAdapter(this)

    override fun setupOnActivityResult(activityResult: ActivityResult) {
        super.setupOnActivityResult(activityResult)
        if (activityResult.resultCode == RESULT_OK) {
            viewModel.getContacts()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getContacts()
    }

    override fun setupViewBinding(): ActivityContactBinding {
        return ActivityContactBinding.inflate(layoutInflater)
    }

    override fun setupUI() {
        binding.apply {
            binding.rv.apply {
                adapter = contactAdapter
                layoutManager =
                    LinearLayoutManager(this@ContactActivity, LinearLayoutManager.VERTICAL, false)
            }

            fab.setOnClickListener {
                startActivityResult.launch(
                    Intent(
                        this@ContactActivity,
                        EditorActivity::class.java
                    ).apply {

                    })
            }
        }
    }

    override fun setupViewModel() {
        viewModel.contactsState.observe(this@ContactActivity) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    it.data?.let { data ->
                        contactAdapter.setContent(data)
                    }
                }
            }
        }

        viewModel.insertState.observe(this@ContactActivity) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    viewModel.getContacts()
                }
            }
        }
    }

    override fun onClickListener(data: ContactModel) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
    }

}