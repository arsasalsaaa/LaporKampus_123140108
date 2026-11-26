package com.laporkampus

import kotlin.test.Test

class UtilTest {

    private fun ulangi(kali: Int, aksi: (Int) -> Unit) {
        for (i in 1..kali) {
            aksi(i)
        }
    }

    @Test
    fun ujiUlangi() {
        ulangi(3) { index ->
            println("Memproses data laporan ke-$index")
        }
    }
}