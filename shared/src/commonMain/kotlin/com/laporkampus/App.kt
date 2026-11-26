package com.laporkampus

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.laporkampus.ui.SapaanPelapor

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

@Composable
fun App() = MaterialTheme {
    Column(
        modifier = Modifier.fillMaxSize().safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SapaanPelapor("Arsa Salsabila") // Uji pemanggilan SapaanPelapor
    }
}