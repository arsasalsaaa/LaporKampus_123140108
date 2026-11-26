package com.laporkampus.model

// Data class Laporan merepresentasikan bentuk formulir data laporan kampus
data class Laporan(
    val id: Int,
    val judul: String,
    val lokasi: String,
    val fotoUrl: String? = null, // URL foto opsional (boleh null jika tidak ada foto)
    val status: StatusLaporan = StatusLaporan.Baru // Status laporan, default adalah Baru
)