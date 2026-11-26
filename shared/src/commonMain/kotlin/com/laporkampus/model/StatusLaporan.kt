package com.laporkampus.model

// Sealed class membatasi hierarki kelas status agar compiler mengetahui semua kemungkinannya
sealed class StatusLaporan {
    // Data object digunakan untuk status tunggal yang tidak membawa data tambahan
    data object Baru : StatusLaporan()

    // Data class digunakan untuk status yang membawa data tambahan (nama petugas)
    data class Diproses(val petugas: String) : StatusLaporan()

    // Data class digunakan untuk status yang membawa data tambahan (catatan penyelesaian)
    data class Selesai(val catatan: String) : StatusLaporan()
}