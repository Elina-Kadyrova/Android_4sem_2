package com.itis.android_4sem_2.data.api.response

import com.google.gson.annotations.SerializedName

data class WinePairing (
    @SerializedName("pairedWines")
    val pairedWines: List<String>,
    @SerializedName("pairingText")
    val pairingText: String,
    @SerializedName("productMatches")
    val productMatches: ProductMatches,
)
