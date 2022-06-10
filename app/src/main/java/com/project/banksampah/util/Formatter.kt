package com.project.banksampah.util

import java.text.DecimalFormat

object Formatter {
    fun rupiahFormat(price: Int): String {
        val formatter = DecimalFormat("#,###")
        return "Rp " + formatter.format(price.toLong())
    }
}
