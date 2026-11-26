package com.laporkampus.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

// Composable function untuk menampilkan teks sapaan nama pelapor
@Composable
fun SapaanPelapor(nama: String) {
    Text(
        text = "Halo, $nama", // Menggabungkan teks salam dengan parameter nama
        fontSize = 24.sp      // Mengatur ukuran font sebesar 24 sp
    )
}