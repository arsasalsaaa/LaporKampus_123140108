package com.laporkampus.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Composable Stateless: Tidak menyimpan state sendiri, menerima nilai (State Turun) & melaporkan ketikan (Event Naik)
@Composable
fun KolomTeks(
    label: String,
    nilai: String,                  // State Turun
    onNilaiUbah: (String) -> Unit   // Event Naik
) {
    OutlinedTextField(
        value = nilai,
        onValueChange = onNilaiUbah,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}