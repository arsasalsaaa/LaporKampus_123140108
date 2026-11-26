package com.laporkampus.data

import kotlinx.coroutines.delay
import com.laporkampus.model.Laporan
import kotlinx.coroutines.Dispatchers // Import Dispatchers untuk manajemen thread
import kotlinx.coroutines.IO // Import ekstensi IO di KMP (kotlinx-coroutines-core)
import kotlinx.coroutines.withContext // Import withContext untuk memindahkan konteks thread

// Suspend function muatDetail memindahkan pekerjaan I/O (jaringan/database) ke Dispatchers.IO
suspend fun muatDetail(id: Int): Laporan = withContext(Dispatchers.IO) {
    ambilLaporan(id) // Eksekusi fungsi pengambil data di dalam thread pool IO
}

// Suspend function mensimulasikan proses ambil data laporan (1000 ms)
suspend fun ambilLaporan(id: Int): Laporan {
    delay(1000) // Pura-pura menunggu respon server selama 1000 ms
    return Laporan(id, "Proyektor mati", "GKU 1 R201")
}

// Suspend function mensimulasikan ambil data riwayat (diubah dari 800 ms menjadi 1500 ms)
suspend fun ambilRiwayat(id: Int): List<String> {
    delay(1500) // Diubah dari 800 ms menjadi 1500 ms sesuai perintah soal
    return listOf("Dikirim 08.10", "Diterima 08.40")
}