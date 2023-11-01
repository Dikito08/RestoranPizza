package com.example.restoranpizza

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menus (
    val imgMenu : Int,
    val namaMenu : String,
    var detailMenu : String,
    val imgDesc : Int,
    val descNama : String,
    val descDetail : String,
    val descHarga : String,
) : Parcelable
