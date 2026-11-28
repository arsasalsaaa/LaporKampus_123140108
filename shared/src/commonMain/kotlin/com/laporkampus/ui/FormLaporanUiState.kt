package com.laporkampus.ui

// Data class penampung seluruh UI State untuk Form Laporan
data class FormLaporanUiState(
    val judul: String = "",
    val lokasi: String = "",
    val prioritas: Int = 3,
    val sedangMengirim: Boolean = false,
    val pesan: String? = null
) {
    // Aturan validasi tombol Kirim: judul minimal 3 huruf & lokasi tidak kosong
    val bisaKirim: Boolean
        get() = judul.isNotBlank() && lokasi.isNotBlank() && !sedangMengirim
}