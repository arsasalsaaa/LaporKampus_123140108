package com.laporkampus.nav

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

// Extension function untuk berpindah tab tanpa menumpuk back stack
fun NavController.pindahTab(rute: Any) {
    navigate(rute) {
        popUpTo(graph.findStartDestination().route!!) {
            saveState = true // Menyimpan state tab yang ditinggalkan
        }
        launchSingleTop = true // Mencegah duplikasi tab yang sama di paling atas
        restoreState = true    // Mengembalikan state tab saat dibuka kembali
    }
}