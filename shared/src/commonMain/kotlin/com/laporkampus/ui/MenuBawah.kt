package com.laporkampus.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.laporkampus.nav.RuteAsisten
import com.laporkampus.nav.RuteBeranda
import com.laporkampus.nav.RuteProfil
import com.laporkampus.nav.pindahTab

// Versi 1: Navigasi Polos (Soal Bagian 2 Nomor 2)
@Composable
fun MenuBawahPolos(nav: NavController) {
    val navBackStackEntry by nav.currentBackStackEntryAsState()
    val destinasi = navBackStackEntry?.destination

    NavigationBar {
        NavigationBarItem(
            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteBeranda>() } == true,
            onClick = { nav.navigate(RuteBeranda) }, // Navigate polos
            icon = { Icon(Icons.Default.Home, contentDescription = "Beranda") },
            label = { Text("Beranda") }
        )
        NavigationBarItem(
            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteAsisten>() } == true,
            onClick = { nav.navigate(RuteAsisten) }, // Navigate polos
            icon = { Icon(Icons.Default.Star, contentDescription = "Asisten") },
            label = { Text("Asisten") }
        )
        NavigationBarItem(
            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteProfil>() } == true,
            onClick = { nav.navigate(RuteProfil) }, // Navigate polos
            icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
            label = { Text("Profil") }
        )
    }
}

//// Versi 2: Navigasi Rapi dengan pindahTab (Soal Bagian 2 Nomor 3)
//@Composable
//fun MenuBawahRapi(nav: NavController) {
//    val navBackStackEntry by nav.currentBackStackEntryAsState()
//    val destinasi = navBackStackEntry?.destination
//
//    NavigationBar {
//        NavigationBarItem(
//            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteBeranda>() } == true,
//            onClick = { nav.pindahTab(RuteBeranda) },
//            icon = { Icon(Icons.Default.Home, contentDescription = "Beranda") },
//            label = { Text("Beranda") }
//        )
//        NavigationBarItem(
//            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteAsisten>() } == true,
//            onClick = { nav.pindahTab(RuteAsisten) },
//            icon = { Icon(Icons.Default.Star, contentDescription = "Asisten") },
//            label = { Text("Asisten") }
//        )
//        NavigationBarItem(
//            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteProfil>() } == true,
//            onClick = { nav.pindahTab(RuteProfil) },
//            icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
//            label = { Text("Profil") }
//        )
//    }
//}