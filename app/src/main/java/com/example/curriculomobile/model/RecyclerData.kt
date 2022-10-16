package com.example.curriculomobile.model

import androidx.annotation.DrawableRes

data class RecyclerData(
    var id : Int,
    @DrawableRes var image : Int,
    var text : String
)
