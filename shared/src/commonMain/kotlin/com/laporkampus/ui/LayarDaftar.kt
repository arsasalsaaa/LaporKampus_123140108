package com.laporkampus.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laporkampus.model.Laporan

// LayarDaftar menampilkan susunan item dalam Column
@Composable
fun LayarDaftar(semua: List<Laporan> = emptyList()) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        // UJI TIGA VARIASI ARRANGEMENT:
        // 1. Arrangement.spacedBy(12.dp) -> Memberi jarak 12dp antar elemen
        // 2. Arrangement.SpaceBetween   -> Menyebar elemen dari atas ke bawah
        // 3. Arrangement.Center         -> Menempatkan seluruh elemen di tengah vertikal
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("LaporKampus", fontSize = 28.sp)
        Text("${semua.size} laporan aktif", color = Color.Gray)
        semua.take(3).forEach {
            Text(it.judul)
        }
    }
}