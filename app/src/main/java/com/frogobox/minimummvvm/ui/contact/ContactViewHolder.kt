package com.frogobox.minimummvvm.ui.contact

import androidx.recyclerview.widget.RecyclerView
import com.frogobox.minimummvvm.databinding.ItemContactBinding
import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.util.RvListener

/**
 * Created by faisalamircs on 30/07/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


class ContactViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(data: ContactModel, listener: RvListener) {

        binding.apply {
            tvName.text = data.name
            tvPhoneNumber.text = data.phone
            tvBio.text = "${data.age} year, ${data.gender}, ${data.hobby}"
        }

        itemView.setOnClickListener { listener.onClickListener(data) }

    }

}