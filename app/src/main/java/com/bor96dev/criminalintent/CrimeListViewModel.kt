package com.bor96dev.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

private const val TAG = "Money"

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        Log.d(TAG, "init starting")

        viewModelScope.launch {
            Log.d(TAG, "coroutine launch")
            delay(5000)
            crimes += loadCrimes()
            Log.d(TAG, "Loading crimes finished")
        }

    }

    suspend fun loadCrimes(): List<Crime> {
        val result = mutableListOf<Crime>()

        delay(5000)
        for (i in 0 until 100) {
            val crime = Crime(
                UUID.randomUUID(),
                "Crime $i",
                Date(),
                i % 2 == 0
            )
            result += crime
        }
        return result

    }

}