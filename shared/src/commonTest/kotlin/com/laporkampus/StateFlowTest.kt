package com.laporkampus

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class StateFlowTest {

    @Test
    fun ujiStateFlow() = runBlocking {
        val aliranState = MutableStateFlow("Awal")

        // Mengubah nilai StateFlow beberapa kali
        aliranState.value = "Nilai A"
        aliranState.value = "Nilai B"
        aliranState.value = "Nilai B"

        println("Nilai akhir StateFlow: ${aliranState.value}")
    }
}

// Sifat StateFlow:
// • StateFlow selalu menyimpan SATU nilai terbaru (State).
// • Berbeda dengan Flow biasa, StateFlow selalu punya nilai awal (initial value).
// • Ketika pembaca (collector) baru mulai membaca StateFlow, ia hanya akan menerima
//   nilai paling akhir saat itu ("Nilai B"). Perubahan nilai lama yang terjadi sebelumnya tidak akan dipancarkan ulang.