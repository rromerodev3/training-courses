package com.roy.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val nameRes: Int,
    val count: Int,
    @DrawableRes val imageRes: Int
)