package com.laporkampus.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.laporkampus.model.Laporan

// Composable KartuLaporan menampilkan informasi ringkas/lengkap satu laporan
@Composable
fun KartuLaporan(
    laporan: Laporan,               // Parameter wajib berisi data laporan
    ringkas: Boolean = false,       // Mode ringkas (jika true, lokasi disembunyikan)
    onKlik: () -> Unit = {}         // Lambda callback saat kartu diklik
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()         // Memenuhi lebar maksimal layar
            .clickable { onKlik() },// Menangani interaksi sentuhan/klik
        elevation = CardDefaults.cardElevation(2.dp) // Memberi efek bayangan kartu 2dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp), // Padding dalam 16dp
            verticalAlignment = Alignment.CenterVertically      // Memosisikan isi vertikal di tengah
        ) {
            Column(modifier = Modifier.weight(1f)) { // Weight 1f mengambil sisa ruang kiri
                Text(laporan.judul, fontWeight = FontWeight.Bold) // Judul bercetak tebal
                if (!ringkas) { // Tampilkan lokasi hanya jika tidak dalam mode ringkas
                    Text(laporan.lokasi, color = Color.Gray)
                }
            }
            LabelStatus(laporan.status) // Menampilkan label status di sebelah kanan
        }
    }
}
