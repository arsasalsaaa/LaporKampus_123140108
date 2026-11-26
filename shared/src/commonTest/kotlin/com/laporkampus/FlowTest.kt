package com.laporkampus

import com.laporkampus.data.SumberLaporanPalsu
import com.laporkampus.model.StatusLaporan
import com.laporkampus.model.label
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.time.measureTime

class FlowTest {

    // SOAL 1: Memanggil collect 2 kali berturut-turut untuk membuktikan sifat Cold Flow
    @Test
    fun ujiSoal1CollectDuaKali() = runBlocking {
        val sumber = SumberLaporanPalsu()
        val aliran = sumber.pantau(7)

        println("--- Pemanggilan Collect Pertama ---")
        val waktu1 = measureTime {
            aliran.collect { println("Log 1: ${it.status.label()}") }
        }
        println("Lama Collect Pertama: $waktu1\n")

        println("--- Pemanggilan Collect Kedua ---")
        val waktu2 = measureTime {
            aliran.collect { println("Log 2: ${it.status.label()}") }
        }
        println("Lama Collect Kedua: $waktu2\n")
    }

    // SOAL 2: Pengujian urutan operator filter sebelum map
    @Test
    fun ujiSoal2FilterDanMap() = runBlocking {
        val sumber = SumberLaporanPalsu()

        sumber.pantau(7)
            .filter { it.status !is StatusLaporan.Baru } // 1. Filter dulu saat tipe data masih Laporan
            .map { it.status.label() }                    // 2. Baru diubah (map) menjadi String label
            .collect { println("Notifikasi: $it") }
    }
}
