package com.laporkampus.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

// Composable TombolAksi menampilkan 3 jenis varian tombol Material 3
@Composable
fun TombolAksi() {
    Column {
        // 1. Button (Filled Button / Tombol Utama)
        Button(onClick = { }) {
            Text("Kirim Laporan")
        }

        // 2. OutlinedButton (Tombol Sekunder bergaris tepi)
        OutlinedButton(onClick = { }) {
            Text("Simpan Draft")
        }

        // 3. TextButton (Tombol Teks tanpa latar/garis)
        TextButton(onClick = { }) {
            Text("Batal")
        }
    }
}