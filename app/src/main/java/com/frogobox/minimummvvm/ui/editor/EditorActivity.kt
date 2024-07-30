package com.frogobox.minimummvvm.ui.editor

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import com.frogobox.minimummvvm.base.BaseActivity
import com.frogobox.minimummvvm.databinding.ActivityEditorBinding
import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.util.Resource
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
class EditorActivity : BaseActivity<ActivityEditorBinding>() {

    private var gender = "Male"

    private var hobby = ""

    var listHobby: Array<String> = arrayOf(
        "C", "Data structures",
        "Interview prep", "Algorithms",
        "DSA with java", "OS"
    )

    private val viewModel: EditorViewModel by viewModels()

    override fun setupViewBinding(): ActivityEditorBinding {
        return ActivityEditorBinding.inflate(layoutInflater)
    }

    override fun setupUI() {
        binding.apply {

            rgGender.setOnCheckedChangeListener { group, checkedId ->

                when (checkedId) {
                    rbMale.id -> {
                        gender = "Male"
                    }

                    rbFemale.id -> {
                        gender = "Female"
                    }
                }

            }

            spinnerHobby.apply {
                val ad = ArrayAdapter(this@EditorActivity, android.R.layout.simple_spinner_item,
                    this@EditorActivity.listHobby
                )
                ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long,
                    ) {
                        this@EditorActivity.hobby = this@EditorActivity.listHobby[position]
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        this@EditorActivity.hobby = "No Hobby"
                    }
                }
                setAdapter(ad)
            }

            btnSubmit.setOnClickListener {
                insertContact()
            }
        }
    }

    override fun setupViewModel() {
        viewModel.insertState.observe(this@EditorActivity) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }

                is Resource.Loading -> {}
                is Resource.Success -> {
                    setResult(RESULT_OK)
                    finish()
                }
            }
        }
    }

    private fun insertContact() {
        val name = binding.etName.text.toString()
        val phone = binding.etPhone.text.toString()
        val age = binding.etAge.text.toString()

        val data = ContactModel(
            name = name,
            phone = phone,
            age = age.toInt(),
            gender = gender,
            hobby = hobby
        )

        viewModel.insertContact(data)
    }

}