package com.laporkampus.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laporkampus.model.label

@Composable
fun LayarDetail(
    state: DetailUiState,
    kembali: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TextButton(onClick = kembali) {
            Text("← Kembali")
        }

        // Memeriksa 3 keadaan UI State
        when (state) {
            is DetailUiState.Memuat -> {
                CircularProgressIndicator() // 1. Keadaan Memuat
            }
            is DetailUiState.TidakDitemukan -> {
                Text("Laporan tidak ditemukan", fontSize = 18.sp, color = Color.Red) // 2. Tidak Ditemukan
            }
            is DetailUiState.Ada -> {
                val laporan = state.laporan // 3. Data Ada
                Text("#${laporan.id} ${laporan.judul}", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text(laporan.lokasi, color = Color.Gray)
                LabelStatus(laporan.status)
                Text("Detail Status: ${laporan.status.label()}")
            }
        }
    }
}