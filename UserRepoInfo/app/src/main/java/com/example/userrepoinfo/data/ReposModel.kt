package com.example.userrepoinfo.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ReposModel(
  var name: String,
  var description: String
): Parcelable