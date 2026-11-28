package com.laporkampus.nav

import kotlinx.serialization.Serializable

// Rute bertipe (Type-Safe Navigation) dengan anotasi @Serializable

@Serializable
object RuteBeranda // Rute alamat layar utama (Daftar Laporan)

@Serializable
data class RuteDetail(val id: Int) // Rute detail yang membawa parameter ID bertipe Int

@Serializable
object RuteForm // Rute alamat layar Form Tambah Laporan

@Serializable
object RuteAsisten // Rute alamat layar Asisten AI Gemini

@Serializable
object RuteProfil // Rute alamat layar Profil Pelapor