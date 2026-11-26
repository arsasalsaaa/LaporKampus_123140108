package com.laporkampus.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.laporkampus.model.StatusLaporan

@Composable
fun FotoAtauKosong(url: String?) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color(0xFFF1EDE1)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            if (url == null) "Belum ada foto" else "Foto tersedia",
            color = Color.Gray
        )
    }
}

@Composable
fun LabelStatus(status: StatusLaporan) {
    val (teks, warna) = when (status) {
        StatusLaporan.Baru -> "Baru" to Color(0xFFE6E2D6)
        is StatusLaporan.Diproses -> "Diproses" to Color(0xFFF6EDCF)
        is StatusLaporan.Selesai -> "Selesai" to Color(0xFFDCEFD6)
        is StatusLaporan.Ditolak -> "Ditolak" to Color(0xFFFFCDD2)
    }

    Text(
        text = teks,
        fontSize = 12.sp,
        modifier = Modifier
            .background(warna, RoundedCornerShape(50)) // Bentuk pil bundar 50%
            .padding(horizontal = 12.dp, vertical = 4.dp)
    )
}

