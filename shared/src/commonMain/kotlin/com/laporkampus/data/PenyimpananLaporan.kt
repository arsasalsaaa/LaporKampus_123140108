package com.laporkampus.data

import com.laporkampus.contohLaporanList
import com.laporkampus.model.Laporan
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.laporkampus.model.StatusLaporan

// Singleton penyimpan daftar laporan bersama yang menghubungkan layar Form dan Daftar
object PenyimpananLaporan {
    // State internal daftar laporan dengan data awal dari contohLaporanList
    private val _daftar = MutableStateFlow(contohLaporanList)
    // State publik read-only yang diamati oleh layar daftar
    val daftar: StateFlow<List<Laporan>> = _daftar.asStateFlow()

    // Menambahkan laporan baru ke dalam list secara immutable dan memicu pembaruan UI
    fun tambah(judul: String, lokasi: String) = _daftar.update { lama ->
        lama + Laporan(
            id = lama.size + 1, // Membuat ID baru berurutan
            judul = judul,
            lokasi = lokasi,
            fotoUrl = null
        )
    }

    fun ubahStatus(id: Int, statusBaru: StatusLaporan) = _daftar.update { lama ->
        lama.map { laporan ->
            if (laporan.id == id) laporan.copy(status = statusBaru) else laporan
        }
    }
}

