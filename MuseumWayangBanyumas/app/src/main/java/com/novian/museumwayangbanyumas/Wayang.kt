package com.novian.museumwayangbanyumas

data class Wayang(
    val id : String? = null,
    val gambar : String? = null,
    val nama : String? = null,
    val deskripsi : String? = null
) {
    constructor(): this("", "", "", ""){

    }
}