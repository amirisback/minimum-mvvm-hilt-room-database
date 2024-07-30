package com.frogobox.minimummvvm.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.minimummvvm.model.ContactModel
import com.frogobox.minimummvvm.R
import com.frogobox.minimummvvm.util.RvListener


/**
 * Created by faisalamir on 07/02/22
 * recyclercoroutines
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 FrogoBox Inc.      
 * All rights reserved
 *
 */

class MainAdapter(private val listener: RvListener) : RecyclerView.Adapter<MainHolder>(){

    private val listData = mutableListOf<ContactModel>()

    fun setContent(data: List<ContactModel>) {
        listData.clear()
        listData.addAll(data)
    }

    fun notifyInserted(data: ContactModel, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
    }

    fun clearData() {
        listData.clear()
        notifyItemRangeRemoved(0, listData.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bindItem(listData[position], listener)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

}