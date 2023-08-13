package com.bor96dev.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bor96dev.criminalintent.databinding.ListItemCrimeBinding
import java.util.UUID


class CrimeListAdapter(
    private val crimes: List<Crime>,
    private val onCrimeClicked: (crimeId: UUID) -> Unit,
) :
    RecyclerView.Adapter<CrimeListAdapter.CrimeHolder>() {

    class CrimeHolder(
        val binding: ListItemCrimeBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime, onCrimeClicked: (crimeId: UUID) -> Unit) {
            binding.crimeTitleRv.text = crime.title
            binding.crimeDateRv.text = crime.date.toString()
            binding.crimeSolvedImg.visibility = if (crime.isSolved) View.VISIBLE else View.INVISIBLE

            binding.root.setOnClickListener {
                onCrimeClicked(crime.id)
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
        holder.bind(crime, onCrimeClicked)
    }

}
