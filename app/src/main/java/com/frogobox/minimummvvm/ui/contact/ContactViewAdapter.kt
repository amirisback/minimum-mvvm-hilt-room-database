package com.frogobox.minimummvvm.ui.contact

import android.view.LayoutInflater
import android.view.ViewGroup
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


class ContactViewAdapter(private val listener: RvListener) : RecyclerView.Adapter<ContactViewHolder>(){

    private val listData = mutableListOf<ContactModel>()

    fun setContent(data: List<ContactModel>) {
        listData.clear()
        listData.addAll(data)
        notifyDataSetChanged()
    }

    fun notifyInserted(data: ContactModel, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
    }

    fun clearData() {
        listData.clear()
        notifyItemRangeRemoved(0, listData.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bindItem(listData[position], listener)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}