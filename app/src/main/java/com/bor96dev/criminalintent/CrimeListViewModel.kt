package com.bor96dev.criminalintent

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class CrimeListViewModel: ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100){
            val crime = Crime(
                UUID.randomUUID(),
                "Crime #$i",
                Date(),
                i % 2 == 0
            )
            crimes += crime
        }
    }

}