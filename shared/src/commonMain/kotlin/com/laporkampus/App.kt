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
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.Button
import com.laporkampus.model.Laporan // Mengimpor data class Laporan dari modul 2
import com.laporkampus.model.StatusLaporan // Mengimpor sealed class StatusLaporan dari modul 2
import com.laporkampus.ui.BarisLokasi // Mengimpor composable BarisLokasi
import com.laporkampus.ui.DaftarLaporan // Mengimpor composable DaftarLaporan dengan LazyColumn
import com.laporkampus.ui.SapaanPelapor // Mengimpor composable SapaanPelapor
import com.laporkampus.ui.TombolAksi // Mengimpor composable TombolAksi
import com.laporkampus.ui.FormLaporanBiasa // Mengimpor composable FormLaporanBiasa()
import com.laporkampus.ui.FormLaporanState
import com.laporkampus.ui.FormLaporan
import com.laporkampus.ui.FormLaporanScreen
import com.laporkampus.data.PenyimpananLaporan
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.laporkampus.nav.RuteAsisten
import com.laporkampus.nav.RuteBeranda
import com.laporkampus.nav.RuteDetail
import com.laporkampus.nav.RuteForm
import com.laporkampus.nav.RuteProfil
import com.laporkampus.ui.DetailViewModel
import com.laporkampus.ui.LayarDetail

// Contoh data awal laporan untuk diisikan ke PenyimpananLaporan
val contohLaporanList = listOf(
    Laporan(1, "Proyektor mati", "GKU 1 R201", null, StatusLaporan.Baru),
    Laporan(2, "AC bocor", "Lab Komputer 2", null, StatusLaporan.Diproses("Pak Joko")),
    Laporan(3, "Lampu tidak menyala", "GKU 2 R103", null, StatusLaporan.Ditolak("Bukan fasilitas umum")),
    Laporan(4, "Pintu rusak", "Perpustakaan Lt. 2", null, StatusLaporan.Selesai("Engsel diganti"))
)

@Composable
fun App() = MaterialTheme {
    // Controller sebagai pengemudi navigasi
    val nav = rememberNavController()

    Scaffold { innerPadding ->
        // NavHost menggantikan pernyataan when manual sebagai peta alamat rute navigasi 5 rute
        NavHost(
            navController = nav,
            startDestination = RuteBeranda, // Destinasi awal layar
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Rute 1: Layar Beranda (Sapaan + Tombol Navigasi + Daftar Laporan)
            composable<RuteBeranda> {
                val daftar by PenyimpananLaporan.daftar.collectAsState()

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SapaanPelapor(nama = "Arsa Salsabila")

                    // Baris tombol navigasi ke RuteForm, RuteAsisten, dan RuteProfil
                    Row(
                        modifier = Modifier.padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(onClick = { nav.navigate(RuteForm) }) {
                            Text("Form Lapor")
                        }
                        Button(onClick = { nav.navigate(RuteAsisten) }) {
                            Text("Asisten AI")
                        }
                        Button(onClick = { nav.navigate(RuteProfil) }) {
                            Text("Profil")
                        }
                    }

                    DaftarLaporan(
                        semua = daftar,
                        onPilih = { laporan ->
                            nav.navigate(RuteDetail(laporan.id)) // Navigasi ke RuteDetail membawa ID
                        }
                    )
                }
            }

            // Rute 2: Layar Detail Laporan
            composable<RuteDetail> { entry ->
                val rute: RuteDetail = entry.toRoute() // Mengambil parameter argument ID dari rute
                val vm = viewModel(key = "detail_${rute.id}") { DetailViewModel(rute.id) }
                val state by vm.uiState.collectAsState()

                LayarDetail(
                    state = state,
                    kembali = { nav.popBackStack() } // Kembali ke layar sebelumnya
                )
            }

            // Rute 3: Layar Form Laporan
            composable<RuteForm> {
                FormLaporanScreen(
                    selesai = { nav.popBackStack() } // Pop back stack setelah laporan terkirim
                )
            }

            // Rute 4: Layar Asisten AI Gemini
            composable<RuteAsisten> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    TextButton(onClick = { nav.popBackStack() }) {
                        Text("← Kembali")
                    }
                    Text("Asisten AI Gemini", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Layar Asisten AI untuk membantu pelaporan kampus.")
                }
            }

            // Rute 5: Layar Profil Pelapor
            composable<RuteProfil> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    TextButton(onClick = { nav.popBackStack() }) {
                        Text("← Kembali")
                    }
                    Text("Profil Pelapor", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Text("Nama: Arsa Salsabila")
                    Text("NIM: 123140108")
                    Text("Role: Mahasiswa / Pelapor Utama")
                }
            }
        }
    }
}

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

//@Composable
//fun App() = MaterialTheme { // Pembungkus utama tema aplikasi Material 3
//    Column( // Kolom utama penyusun layar aplikasi
//        modifier = Modifier
//            .fillMaxSize() // Memenuhi seluruh tinggi dan lebar layar
//            .safeDrawingPadding() // Mencegah UI tertutup oleh status bar dan lubang kamera
//            .padding(horizontal = 16.dp), // Memberikan padding kiri-kanan sebesar 16dp
//        horizontalAlignment = Alignment.CenterHorizontally // Meratakan seluruh anak ke tengah horizontal
//    ) {
//        // 1. Menampilkan sapaan pelapor (Soal Bagian 1.1)
//        SapaanPelapor(nama = "Arsa Salsabila")
//
//        // 2. Menampilkan 3 varian tombol aksi (Soal Bagian 1.3)
//        TombolAksi()
//
//        // 3. Menampilkan baris lokasi dengan weight 2f dan 1f (Soal Bagian 2.2)
//        BarisLokasi(
//            lokasi = "Gedung Kuliah Umum (GKU) 1 R201",
//            waktu = "10 menit lalu"
//        )
//        // FormLaporanBiasa()
//        // FormLaporanState() // Form laporan pakai remember & mutableStateOf
//        // Ini real
//        FormLaporan()
//        // 4. Menampilkan daftar laporan panjang menggunakan LazyColumn (Soal Bagian 3.2 & 3.3)
//        DaftarLaporan(
//            semua = contohLaporanList, // Mengirimkan sampel daftar laporan
//            onPilih = { laporan -> // Lambda callback saat kartu laporan diklik
//                println("Laporan terpilih: ${laporan.judul}")
//            }
//        )
//    }
//}