package com.laporkampus.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormLaporan() {
    var judul by remember { mutableStateOf("") }
    var lokasi by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        KolomTeks("Judul", judul) { judul = it }
        KolomTeks("Lokasi", lokasi) { lokasi = it }
        Text("Pratinjau:: $judul di $lokasi") // Menampilkan nilai state)

        Button(onClick = {
            judul = ""   // Mengosongkan state judul dari luar
            lokasi = ""  // Mengosongkan state lokasi dari luar
        }) {
            Text("Kosongkan Form")
        }
    }
}