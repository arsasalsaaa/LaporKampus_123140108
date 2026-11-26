package com.laporkampus.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.laporkampus.model.Laporan
import com.laporkampus.model.StatusLaporan

// Composable DaftarLaporan menampilkan daftar panjang laporan menggunakan LazyColumn
@Composable
fun DaftarLaporan(
    semua: List<Laporan>,
    onPilih: (Laporan) -> Unit = {}
) {
    // Saring laporan yang belum Selesai dan urutkan ID terbesar (terbaru di atas)
    val laporanBelumSelesai = semua
        .filter { it.status !is StatusLaporan.Selesai }
        .sortedByDescending { it.id }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),         // Jarak tepi dalam 16dp
        verticalArrangement = Arrangement.spacedBy(12.dp) // Jarak antar kartu 12dp
    ) {
        items(laporanBelumSelesai, key = { it.id }) { laporan -> // Key ID untuk efisiensi daur ulang
            KartuLaporan(
                laporan = laporan,
                onKlik = { onPilih(laporan) }
            )
        }
    }
}
