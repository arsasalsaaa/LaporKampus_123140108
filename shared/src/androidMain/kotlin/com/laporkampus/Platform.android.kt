package com.laporkampus

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

/**
 * -----------------------------------------------------------------------------
 * PENJELASAN MATERI: EXPECT & ACTUAL (Kotlin Multiplatform)
 * -----------------------------------------------------------------------------
 * 
 * 2. Kata kunci `actual`:
 *    - Digunakan di dalam source set spesifik platform (misalnya androidMain).
 *    - Berfungsi untuk menyediakan implementasi nyata (konkret) dari deklarasi 
 *      `expect` yang telah didefinisikan di common code.
 *    - Nama dan tanda tangan (signature) harus cocok persis dengan `expect`.
 *    - Di sini, `actual fun getPlatform()` diimplementasikan menggunakan 
 *      library/API khusus Android (`Build.VERSION.SDK_INT`).
 */
actual fun getPlatform(): Platform = AndroidPlatform()