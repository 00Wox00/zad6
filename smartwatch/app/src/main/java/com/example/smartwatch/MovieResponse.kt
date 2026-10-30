package com.example.smartwatch

import com.google.gson.annotations.SerializedName

class MovieResponse(
    @SerializedName("Title") val title: String?,
    @SerializedName("Poster") val poster: String?,
    @SerializedName("Response") val response: String?
)