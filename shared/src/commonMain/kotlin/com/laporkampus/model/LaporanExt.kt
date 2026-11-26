package com.laporkampus.model

// Extension function pada StatusLaporan untuk mengubah objek status menjadi kalimat label
fun StatusLaporan.label(): String = when (this) {
    StatusLaporan.Baru -> "Menunggu petugas" // Jika Baru, tampilkan teks menunggu
    is StatusLaporan.Diproses -> "Ditangani $petugas" // Smart-cast: variabel petugas langsung diakses
    is StatusLaporan.Selesai -> "Selesai: $catatan" // Smart-cast: variabel catatan langsung diakses
    is StatusLaporan.Ditolak -> "Ditolak: $alasan" // Perbaikan untuk menangani status ditolak
}

// Extension function pada Laporan untuk membuat ringkasan singkat laporan
fun Laporan.ringkas(): String = "#$id $judul, $lokasi"

// Extension function untuk mengecek keberadaan foto secara aman tanpa operator !!
fun Laporan.adaFoto(): Boolean = !fotoUrl.isNullOrBlank()