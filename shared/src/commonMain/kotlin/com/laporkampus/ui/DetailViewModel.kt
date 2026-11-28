package com.laporkampus.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laporkampus.data.PenyimpananLaporan
import com.laporkampus.model.Laporan
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

// Sealed class merepresentasikan 3 keadaan layar detail
sealed class DetailUiState {
    data object Memuat : DetailUiState()
    data class Ada(val laporan: Laporan) : DetailUiState()
    data object TidakDitemukan : DetailUiState()
}

// ViewModel menerima id laporan dan mencari datanya sendiri dari PenyimpananLaporan
class DetailViewModel(id: Int) : ViewModel() {
    val uiState: StateFlow<DetailUiState> = PenyimpananLaporan.daftar
        .map { semua ->
            val laporan = semua.find { it.id == id }
            if (laporan == null) DetailUiState.TidakDitemukan
            else DetailUiState.Ada(laporan)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = DetailUiState.Memuat
        )
}