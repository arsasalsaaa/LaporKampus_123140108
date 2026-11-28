package com.laporkampus.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.LaunchedEffect // Import LaunchedEffect

@Composable
fun FormLaporanScreen(
    vm: FormLaporanViewModel = viewModel { FormLaporanViewModel() },
    selesai: () -> Unit = {} // Parameter lambda callback saat proses selesai
) {
    val state by vm.uiState.collectAsState()

    // LaunchedEffect memantau perubahan state.pesan
    LaunchedEffect(state.pesan) {
        if (state.pesan != null) {
            selesai() // Otomatis memanggil kembali/popBackStack saat pesan sukses muncul
        }
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TextButton(onClick = selesai) {
            Text("← Kembali")
        }

        Text("Tambah Laporan Baru", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        KolomTeks("Judul Laporan", state.judul, vm::ubahJudul)
        if (state.judul.isNotEmpty() && state.judul.trim().length < 3) {
            Text("Judul minimal 3 karakter", color = Color.Red)
        }
        KolomTeks("Lokasi", state.lokasi, vm::ubahLokasi)

        Button(
            onClick = { vm.kirimLaporan() },
            enabled = state.bisaKirim
        ) {
            Text(if (state.sedangMengirim) "Mengirim..." else "Kirim Laporan")
        }
    }
}

//@Composable
//fun FormLaporanScreen(
//    vm: FormLaporanViewModel = viewModel { FormLaporanViewModel() }
//) {
//    // Mengamati perubahan StateFlow agar UI otomatis recomposition
//    val state by vm.uiState.collectAsState()
//
//    Column(
//        modifier = Modifier.padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        KolomTeks("Judul Laporan", state.judul, vm::ubahJudul)
//
//        // Tampilkan pesan galat jika pengguna sudah mengetik tapi kurang dari 3 karakter
//        if (state.judul.isNotEmpty() && state.judul.trim().length < 3) {
//            Text("Judul minimal 3 karakter", color = Color.Red)
//        }
//
//        KolomTeks("Lokasi", state.lokasi, vm::ubahLokasi)
//
//        Button(
//            onClick = { vm.kirimLaporan() },
//            enabled = state.bisaKirim // Tombol aktif mengikuti aturan bisaKirim di UiState
//        ) {
//            Text(if (state.sedangMengirim) "Mengirim..." else "Kirim")
//        }
//
//        // Tampilkan pesan sukses setelah laporan terkirim
//        state.pesan?.let {
//            Text(it, color = Color(0xFF2E7D32))
//        }
//    }
//}