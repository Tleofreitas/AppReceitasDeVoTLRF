package com.example.appreceitasdevotlrf

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


// import java.io.Serializable

@Parcelize
data class Receita(
    val titulo: String,
    val tempo: String,
    val resIdImagem: Int,
    val igredientes: List<String>
) : Parcelable

/*
data class Receita(
    val titulo: String,
    val tempo: String,
    val resIdImagem: Int
) : Serializable
*/
