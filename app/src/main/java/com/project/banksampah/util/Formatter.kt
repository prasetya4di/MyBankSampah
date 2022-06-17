package com.project.banksampah.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

object Formatter {
    fun rupiahFormat(price: Int): String {
        val formatter = DecimalFormat("#,###")
        return "Rp " + formatter.format(price.toLong())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun dateFormat(date: Date): String {
        val localDateTime: LocalDateTime = date
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDateTime()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
        return formatter.format(localDateTime)
    }
}
