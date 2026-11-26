package com.laporkampus.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun BarisLokasi(lokasi: String, waktu: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Place, contentDescription = "Ikon Lokasi")
        Spacer(modifier = Modifier.width(6.dp))
        // Memberikan bobot ruang 2f pada teks lokasi
        Text(lokasi, modifier = Modifier.weight(2f))
        // Memberikan bobot ruang 1f pada teks waktu
        Text(
            text = waktu,
            modifier = Modifier.weight(1f),
            color = Color.Gray,
            textAlign = TextAlign.End
        )
    }
}