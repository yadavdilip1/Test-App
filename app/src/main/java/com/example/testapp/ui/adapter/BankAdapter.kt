package com.example.testapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.data.model.Result
import com.example.testapp.databinding.ItemBankBinding
import com.example.testapp.ui.ItemClick

class BankAdapter(val listner: ItemClick): RecyclerView.Adapter<BankAdapter.DataViewHolder>() {

    var item = listOf<Result>()
    set(value)
    { field = value
        notifyDataSetChanged()
    }

    inner class DataViewHolder(val binding : ItemBankBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {

        val binding = ItemBankBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DataViewHolder(binding)


    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

        with(holder) {
            with(item[position]) {

                binding.bankName.text = this.name
                binding.mainLyt.setOnClickListener {
                    listner.itemClick(this)
                }

            }

        }
    }

    override fun getItemCount(): Int = item.size



}