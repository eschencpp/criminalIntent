package com.example.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()
    init{
        Log.d(TAG, "init starting")
        viewModelScope.launch {
            Log.d(TAG, "coroutines launched")
            crimes += loadCrimes()
            Log.d(TAG, "Loading crimes finished")
        }

        suspend fun loadCrimes(): List<Crime> {
            return CrimeRepository.getCrimes()
        }
    }


}