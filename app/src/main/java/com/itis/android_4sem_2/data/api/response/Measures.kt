package com.itis.android_4sem_2.data.api.response

import com.google.gson.annotations.SerializedName

class Measures (
    @SerializedName("metric")
    val metric: Metric,
    @SerializedName("us")
    val us: Us,
)
