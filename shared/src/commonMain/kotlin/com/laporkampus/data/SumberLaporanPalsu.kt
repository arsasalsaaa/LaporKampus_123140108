package com.laporkampus.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.laporkampus.model.Laporan
import com.laporkampus.model.StatusLaporan

// Interface Sumber sebagai kontrak penyedia data
interface Sumber<T> {
    suspend fun ambil(id: Int): T
    fun pantau(id: Int): Flow<T>
}

// Fungsi pembantu membuat objek contoh laporan awal
fun contohLaporan(id: Int) = Laporan(id, "Proyektor mati", "GKU 1 R201", null, StatusLaporan.Baru)

// Kelas konkret SumberLaporanPalsu
class SumberLaporanPalsu : Sumber<Laporan> {
    override suspend fun ambil(id: Int): Laporan {
        delay(1000) // Simulasi delay mengambil satu laporan
        return contohLaporan(id)
    }

    // SOAL 3: Melengkapi fungsi pantau untuk memancarkan 3 perubahan status laporan dengan copy()
    override fun pantau(id: Int): Flow<Laporan> = flow {
        val awal = contohLaporan(id)

        // 1. Pancarkan status awal (Baru)
        emit(awal)
        delay(1500) // Tunggu 1.5 detik

        // 2. Pancarkan status kedua (Diproses) menggunakan copy()
        emit(awal.copy(status = StatusLaporan.Diproses("Pak Joko")))
        delay(2000) // Tunggu 2 detik

        // 3. Pancarkan status ketiga (Selesai) menggunakan copy()
        emit(awal.copy(status = StatusLaporan.Selesai("Lampu proyektor diganti")))
    }
}