package com.laporkampus

import androidx.compose.foundation.layout.Column // Mengatur tata letak elemen secara vertikal (atas ke bawah)
import androidx.compose.foundation.layout.fillMaxSize // Membuat tata letak memenuhi seluruh area layar
import androidx.compose.foundation.layout.padding // Memberikan jarak (margin/padding) pada elemen
import androidx.compose.foundation.layout.safeDrawingPadding // Memberikan jarak aman dari status bar & notch camera
import androidx.compose.material3.MaterialTheme // Mengaplikasikan tema warna & tipografi Material 3
import androidx.compose.runtime.Composable // Anotasi wajib untuk penanda fungsi pembuat UI Compose
import androidx.compose.ui.Alignment // Mengatur perataan posisi horizontal elemen
import androidx.compose.ui.Modifier // Mengatur modifier gaya visual, jarak, dan interaksi
import androidx.compose.ui.unit.dp // Satuan ukuran piksel mandiri kepadatan (density-independent pixels)
import com.laporkampus.model.Laporan // Mengimpor data class Laporan dari modul 2
import com.laporkampus.model.StatusLaporan // Mengimpor sealed class StatusLaporan dari modul 2
import com.laporkampus.ui.BarisLokasi // Mengimpor composable BarisLokasi
import com.laporkampus.ui.DaftarLaporan // Mengimpor composable DaftarLaporan dengan LazyColumn
import com.laporkampus.ui.SapaanPelapor // Mengimpor composable SapaanPelapor
import com.laporkampus.ui.TombolAksi // Mengimpor composable TombolAksi
import com.laporkampus.ui.FormLaporanBiasa // Mengimpor composable FormLaporanBiasa()
import com.laporkampus.ui.FormLaporanState
import com.laporkampus.ui.FormLaporan

//@Composable
//fun App() = MaterialTheme {
//    var tampil by remember { mutableStateOf(false) }
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .safeDrawingPadding(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Halo, Arsa Salsabila")
//        Text("NIM: 123140108")
//        Button(onClick = { tampil = !tampil }) {
//            Text("Cek platform")
//        }
//        AnimatedVisibility(tampil) { Text(sapaan()) }
//    }
//}

// Definisi variabel contohLaporanList agar tidak merah saat dipanggil di App()
val contohLaporanList = listOf(
    Laporan(1, "Proyektor mati", "GKU 1 R201", null, StatusLaporan.Baru),
    Laporan(2, "AC bocor", "Lab Komputer 2", null, StatusLaporan.Diproses("Pak Joko")),
    Laporan(3, "Lampu tidak menyala", "GKU 2 R103", null, StatusLaporan.Ditolak("Bukan fasilitas umum")),
    Laporan(4, "Pintu rusak", "Perpustakaan Lt. 2", null, StatusLaporan.Selesai("Engsel diganti"))
)

@Composable
fun App() = MaterialTheme { // Pembungkus utama tema aplikasi Material 3
    Column( // Kolom utama penyusun layar aplikasi
        modifier = Modifier
            .fillMaxSize() // Memenuhi seluruh tinggi dan lebar layar
            .safeDrawingPadding() // Mencegah UI tertutup oleh status bar dan lubang kamera
            .padding(horizontal = 16.dp), // Memberikan padding kiri-kanan sebesar 16dp
        horizontalAlignment = Alignment.CenterHorizontally // Meratakan seluruh anak ke tengah horizontal
    ) {
        // 1. Menampilkan sapaan pelapor (Soal Bagian 1.1)
        SapaanPelapor(nama = "Arsa Salsabila")

        // 2. Menampilkan 3 varian tombol aksi (Soal Bagian 1.3)
        TombolAksi()

        // 3. Menampilkan baris lokasi dengan weight 2f dan 1f (Soal Bagian 2.2)
        BarisLokasi(
            lokasi = "Gedung Kuliah Umum (GKU) 1 R201",
            waktu = "10 menit lalu"
        )
        // FormLaporanBiasa()
        // FormLaporanState() // Form laporan pakai remember & mutableStateOf
        // Ini real
        FormLaporan()
        // 4. Menampilkan daftar laporan panjang menggunakan LazyColumn (Soal Bagian 3.2 & 3.3)
        DaftarLaporan(
            semua = contohLaporanList, // Mengirimkan sampel daftar laporan
            onPilih = { laporan -> // Lambda callback saat kartu laporan diklik
                println("Laporan terpilih: ${laporan.judul}")
            }
        )
    }
}
