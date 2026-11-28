### Diagram Aliran Data Satu Arah (State Turun, Event Naik) — `FormLaporan`

```text
+-----------------------------------------------------------------------+
|                    FormLaporan (Pemilik State / Induk)                |
|                                                                       |
|   • var judul  by remember { mutableStateOf("") }                     |
|   • var lokasi by remember { mutableStateOf("") }                     |
|                                                                       |
|   [ Button("Kosongkan Form")       ] ──► judul = ""; lokasi = ""      |
|   [ Text("Pratinjau:: $judul di$lokasi") ] ◄── membaca judul & lokasi|
+---------------+-----------------------------------+-------------------+
                |   ▲                               |   ▲
          State |   | Event                   State |   | Event
          Turun |   | Naik                    Turun |   | Naik
         (nilai |   |(onNilaiUbah:           (nilai |   |(onNilaiUbah:
         =judul)|   | judul = it)            =lokasi|   | lokasi = it)
                ▼   |                               ▼   |
      +-----------------------+           +-----------------------+
      |       KolomTeks       |           |       KolomTeks       |
      |     label="Judul"     |           |     label="Lokasi"    |
      |      (Stateless)      |           |      (Stateless)      |
      +-----------------------+           +-----------------------+