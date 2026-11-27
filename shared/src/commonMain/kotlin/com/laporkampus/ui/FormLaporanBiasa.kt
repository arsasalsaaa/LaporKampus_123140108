package com.laporkampus.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

// FormLaporan versi variabel biasa (Stateless / Bermasalah)
@Composable
fun FormLaporanBiasa() {
    var judul = "" // Variabel lokal biasa (BUKAN State Compose)

    Column {
        TextField(
            value = judul,
            onValueChange = {
                judul = it
                println("Ketik: $it") // Mencetak setiap huruf yang diketik di konsol
            },
            label = { Text("Judul") }
        )
        Text("${judul.length} dari 40 karakter")
    }
}

// Di Konsol: Huruf yang diketik (A dan C) muncul di konsol karena onValueChange tetap menerima input dari keyboard, tetapi tidak tergabung menjadi "AC" karena nilai judul di UI tidak pernah diperbarui.
// Di Layar: Kolom input Judul tetap kosong dan teks penghitung di bawahnya tetap tertulis 0 dari 40 karakter.

// Variabel lokal biasa (var judul = "") tidak bisa dipakai untuk menyimpan data UI yang berubah di Compose, karena nilainya berubah di memori
// tanpa diketahui oleh sistem rendering Compose (Nilainya berubah, tetapi tampilannya tidak tahu).
// Solusinya wajib menggabungkan remember dan mutableStateOf (var judul by remember { mutableStateOf("") }): mutableStateOf bertugas
// memberi tahu Compose saat nilai berubah agar memicu recomposition, sedangkan remember bertugas menyimpan nilai tersebut agar tidak kembali kosong saat fungsi composable dipanggil ulang.
