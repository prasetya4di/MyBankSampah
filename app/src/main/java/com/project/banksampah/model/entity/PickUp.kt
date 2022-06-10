package com.project.banksampah.model.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "pickup")
@Parcelize
class PickUp(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,

    @ColumnInfo(name = "nama_pengguna")
    var name: String,

    @ColumnInfo(name = "jenis_sampah")
    var type: String,

    @ColumnInfo(name = "berat")
    var berat: Int = 0,

    @ColumnInfo(name = "harga")
    var harga: Int = 0,

    @ColumnInfo(name = "tanggal")
    var tanggal: String,

    @ColumnInfo(name = "alamat")
    var alamat: String,

    @ColumnInfo(name = "catatan")
    var catatan: String
) : Parcelable
