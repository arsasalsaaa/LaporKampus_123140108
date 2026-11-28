package com.laporkampus.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember // coba import fungsi remember
import androidx.compose.runtime.mutableStateOf // coba import fungsi mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

// Composable Stateless: Tidak menyimpan state sendiri, menerima nilai (State Turun) & melaporkan ketikan (Event Naik)
@Composable
fun KolomTeks(
    label: String,
    nilai: String,                  // State Turun
    onNilaiUbah: (String) -> Unit   // Event Naik
) {
    OutlinedTextField(
        value = nilai,
        onValueChange = onNilaiUbah,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth()
    )
}

// Kesalahan yang terjadi: Jika KolomTeks menyimpan state di dalam dirinya sendiri (Stateful),
// maka tombol "Kosongkan" di FormLaporan tidak akan bisa mengosongkan teks karena state terisolasi
// di dalam KolomTeks dan tidak dapat diakses atau diubah dari luar. KolomTeks harus Stateless agar
// pemilik state (FormLaporan) dapat mengontrol nilainya.

//@Composable
//fun KolomTeks(
//    label: String,                                                      // Parameter masukan untuk teks petunjuk di dalam kotak input
//    nilai: String,                                                      // Parameter masukan berisi nilai teks terbaru dari induk (FormLaporan)
//    onNilaiUbah: (String) -> Unit                                       // Parameter lambda callback untuk melaporkan ketikan baru ke induk
//) {
//    // ❌ KESALAHAN UMUM: Anak menyimpan state sendiri (Stateful)
//    var isi by remember { mutableStateOf(nilai) }           // Menyimpan salinan state lokal; nilai awal 'nilai' hanya dibaca sekali dan tidak ikut berubah saat induk me-reset
//
//    OutlinedTextField(                                                  // Membuat komponen kotak input teks bergaris tepi
//        value = isi,                                               // Menampilkan state lokal 'teksAnak' (bukan 'nilai' dari induk), sehingga isi kotak terkunci di dalam anak
//        onValueChange = {                                               // Membuka blok aksi yang dijalankan setiap kali pengguna mengetik karakter baru
//            isi = it                                               // Memperbarui state lokal milik komponen anak sendiri
//            onNilaiUbah(it)                                             // Tetap mengirim teks ketikan ke induk (sehingga pratinjau di induk berubah, tapi isi kotak tetap terpisah)
//        },
//        label = { Text(label) }, // Menampilkan teks label di bagian atas/dalam kotak input
//        modifier = Modifier.fillMaxWidth() // Mengatur lebar kotak input agar memenuhi seluruh lebar wadahnya
//    )
//}