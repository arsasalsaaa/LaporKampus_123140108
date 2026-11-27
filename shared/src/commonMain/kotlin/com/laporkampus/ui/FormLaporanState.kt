package com.laporkampus.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun FormLaporanState() {
    // remember menyimpan state di memori Compose agar tidak direset saat recomposition
    var judul by remember { mutableStateOf("") }

    Column {
        TextField(
            value = judul,
            onValueChange = { judul = it }, // State berubah memicu recomposition
            label = { Text("Judul") }
        )
        Text("${judul.length} dari 40 karakter")
    }
}



// 1. Dengan remember { mutableStateOf("") }
// Huruf yang diketik langsung muncul dan jumlah karakter ikut bertambah. mutableStateOf membuat layar diperbarui saat ada ketikan,
// sementara remember menjaga agar teks yang sudah diketik tidak hilang saat pembaruan tersebut terjadi.
// 2. Tanpa remember (var judul by mutableStateOf(""))
// Kolom input tetap kosong dan hitungan karakter macet di angka 0 meskipun tombol sudah ditekan. Layar memang terus diperbarui
// setiap kali mengetik, tetapi karena tidak ada remember yang menyimpan data, teksnya selalu ter-reset kembali menjadi kosong.

// • remember: Bertahan saat terjadi recomposition biasa, tetapi nilainya akan hilang atau direset saat layar dirotasi (karena Activity Android dihancurkan & dibuat ulang).
// • rememberSaveable: Bertahan saat recomposition DAN bertahan saat layar dirotasi (karena otomatis menyimpan state ke Bundle sistem Android).