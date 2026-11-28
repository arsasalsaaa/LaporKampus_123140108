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
//@Composable
//fun MenuBawahPolos(nav: NavController) {
//    val navBackStackEntry by nav.currentBackStackEntryAsState()
//    val destinasi = navBackStackEntry?.destination
//
//    NavigationBar {
//        NavigationBarItem(
//            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteBeranda>() } == true,
//            onClick = { nav.navigate(RuteBeranda) }, // Navigate polos
//            icon = { Icon(Icons.Default.Home, contentDescription = "Beranda") },
//            label = { Text("Beranda") }
//        )
//        NavigationBarItem(
//            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteAsisten>() } == true,
//            onClick = { nav.navigate(RuteAsisten) }, // Navigate polos
//            icon = { Icon(Icons.Default.Star, contentDescription = "Asisten") },
//            label = { Text("Asisten") }
//        )
//        NavigationBarItem(
//            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteProfil>() } == true,
//            onClick = { nav.navigate(RuteProfil) }, // Navigate polos
//            icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
//            label = { Text("Profil") }
//        )
//    }
//}

// Versi 2: Navigasi Rapi dengan pindahTab (Soal Bagian 2 Nomor 3)
@Composable
fun MenuBawahRapi(nav: NavController) {
    val navBackStackEntry by nav.currentBackStackEntryAsState()
    val destinasi = navBackStackEntry?.destination

    NavigationBar {
        NavigationBarItem(
            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteBeranda>() } == true,
            onClick = { nav.pindahTab(RuteBeranda) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Beranda") },
            label = { Text("Beranda") }
        )
        NavigationBarItem(
            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteAsisten>() } == true,
            onClick = { nav.pindahTab(RuteAsisten) },
            icon = { Icon(Icons.Default.Star, contentDescription = "Asisten") },
            label = { Text("Asisten") }
        )
        NavigationBarItem(
            selected = destinasi?.hierarchy?.any { it.hasRoute<RuteProfil>() } == true,
            onClick = { nav.pindahTab(RuteProfil) },
            icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
            label = { Text("Profil") }
        )
    }
}

// Versi 1:
// MenuBawah yang memanggil nav.navigate(rute) secara langsung tanpa pengaturan popUpTo maupun launchSingleTop, setiap kali tab di menu bawah ditekan, tujuan baru terus ditumpuk ke bagian atas back
// stack meskipun halaman tersebut sudah pernah dibuka sebelumnya. Akibatnya, saat dilakukan 4 kali perpindahan tab (Asisten - Profil - Beranda - Asisten), dibutuhkan 5 kali menekan tombol Kembali
// sistem untuk membongkar seluruh riwayat tumpukan tab satu per satu hingga akhirnya keluar dari aplikasi.
// Versi 2:
// Setelah mengganti nav.navigate(rute) polos menjadi fungsi ekstensi nav.pindahTab(rute) yang menerapkan popUpTo ke destinasi awal (RuteBeranda), launchSingleTop = true, dan restoreState = true,
// perilaku tumpukan back stack menjadi jauh lebih rapi. Dengan urutan perpindahan tab yang sama persis sebanyak 4 kali (Asisten $\rightarrow$ Profil $\rightarrow$ Beranda $\rightarrow$ Asisten),
// jumlah tekanan tombol Kembali sistem untuk keluar dari aplikasi berkurang dari 5 kali (pada navigate polos) menjadi hanya 2 kali (dari tab Asisten langsung kembali ke Beranda, lalu keluar aplikasi),
// karena setiap perpindahan tab membersihkan tumpukan tab perantara dan mencegah duplikasi layar yang sama di back stack.