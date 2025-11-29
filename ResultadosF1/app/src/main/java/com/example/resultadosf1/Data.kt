package com.example.resultadosf1


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("items")
    val items: List<Item?>?,
    @SerializedName("meta")
    val meta: Meta?,
    @SerializedName("links")
    val links: Links?
) {
    data class Item(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("ki")
        val ki: String?,
        @SerializedName("maxKi")
        val maxKi: String?,
        @SerializedName("race")
        val race: String?,
        @SerializedName("gender")
        val gender: String?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("image")
        val image: String?,
        @SerializedName("affiliation")
        val affiliation: String?,
        @SerializedName("deletedAt")
        val deletedAt: Any?
    )

    data class Meta(
        @SerializedName("totalItems")
        val totalItems: Int?,
        @SerializedName("itemCount")
        val itemCount: Int?,
        @SerializedName("itemsPerPage")
        val itemsPerPage: Int?,
        @SerializedName("totalPages")
        val totalPages: Int?,
        @SerializedName("currentPage")
        val currentPage: Int?
    )

    data class Links(
        @SerializedName("first")
        val first: String?,
        @SerializedName("previous")
        val previous: String?,
        @SerializedName("next")
        val next: String?,
        @SerializedName("last")
        val last: String?
    )
}