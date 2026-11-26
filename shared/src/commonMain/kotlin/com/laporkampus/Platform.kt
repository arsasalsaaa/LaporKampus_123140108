package com.laporkampus

interface Platform {
    val name: String
}

/**
 * -----------------------------------------------------------------------------
 * PENJELASAN MATERI: EXPECT & ACTUAL (Kotlin Multiplatform)
 * -----------------------------------------------------------------------------
 * 
 * 1. Kata kunci `expect`:
 *    - Digunakan di dalam kode bersama (common code / commonMain).
 *    - Berfungsi sebagai "kontrak" atau deklarasi antarmuka (fungsi/kelas/properti)
 *      yang memberitahu compiler bahwa deklarasi ini ada, namun detail 
 *      implementasinya diserahkan ke masing-masing platform target 
 *      (seperti Android, iOS, JVM/Desktop).
 *    - Di sini, `expect fun getPlatform(): Platform` mendefinisikan bahwa 
 *      setiap platform wajib menyediakan fungsi untuk mengembalikan objek `Platform`.
 */
expect fun getPlatform(): Platform

fun sapaan(): String {
    return "LaporKampus berjalan di ${getPlatform().name}"
}

// ===
