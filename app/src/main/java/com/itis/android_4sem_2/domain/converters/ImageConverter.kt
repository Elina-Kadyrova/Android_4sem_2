package com.itis.android_4sem_2.domain.converters

import javax.inject.Inject

private const val BASE_IMAGE_URL = ""
private const val URL_SUFFIX = ""

class ImageConverter @Inject constructor() {
    fun setImageIconUrl(iconCode: String?): String = BASE_IMAGE_URL + iconCode + URL_SUFFIX
}
