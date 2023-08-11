package com.bor96dev.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bor96dev.criminalintent.databinding.ListItemCrimeBinding


class CrimeListAdapter(private val crimes: List<Crime>) :
    RecyclerView.Adapter<CrimeListAdapter.CrimeHolder>() {

    class CrimeHolder(
        val binding: ListItemCrimeBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            binding.crimeTitleRv.text = crime.title
            binding.crimeDateRv.text = crime.date.toString()

            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "${crime.title} clicked!", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)

    }

    override fun getItemCount(): Int {
        return crimes.size
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

}