package com.laporkampus.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laporkampus.data.PenyimpananLaporan
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// ViewModel menjaga state form tetap aman saat layar dirotasi
class FormLaporanViewModel : ViewModel() {
    // State internal yang hanya bisa diubah di dalam ViewModel
    private val _uiState = MutableStateFlow(FormLaporanUiState())
    // State publik read-only yang diamati oleh UI
    val uiState = _uiState.asStateFlow()

    fun ubahJudul(teks: String) =
        _uiState.update { it.copy(judul = teks.take(40)) } // Batasi judul maks. 40 karakter

    fun ubahLokasi(teks: String) =
        _uiState.update { it.copy(lokasi = teks) }

    fun kirimLaporan() {
        if (!_uiState.value.bisaKirim) return // Cegah kirim jika validasi belum terpenuhi
        viewModelScope.launch {
            _uiState.update { it.copy(sedangMengirim = true) }
            delay(800) // Simulasi proses kirim ke server
            PenyimpananLaporan.tambah(_uiState.value.judul, _uiState.value.lokasi) // Simpan ke daftar bersama (Soal 4)
            _uiState.value = FormLaporanUiState(pesan = "Laporan terkirim") // Reset form & tampilkan pesan sukses
        }
    }
}