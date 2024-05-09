package com.example.fitnessequipment


import com.squareup.moshi.Json

data class Response(
    @field:Json(name = "body")
    val body: Body?,
    @field:Json(name = "header")
    val header: Header?
)

data class Header(
    @field:Json(name = "resultCode")
    val resultCode: String?,
    @field:Json(name = "resultMsg")
    val resultMsg: String?
)

data class Body(
    @field:Json(name = "items")
    val items: Items?,
    @field:Json(name = "numOfRows")
    val numOfRows: Int?,
    @field:Json(name = "pageNo")
    val pageNo: Int?,
    @field:Json(name = "totalCount")
    val totalCount: Int?
)

data class Items(
    @field:Json(name = "item")
    val item: List<Item?>?
)


data class Item(
    @field:Json(name = "dongNm")
    val dongNm: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "lat")
    val lat: String?,
    @field:Json(name = "lot")
    val lot: String?,
    @field:Json(name = "lotNoAddr")
    val lotNoAddr: String?,
    @field:Json(name = "mngInstNm")
    val mngInstNm: String?,
    @field:Json(name = "mngInstTel")
    val mngInstTel: String?,
    @field:Json(name = "mngNo")
    val mngNo: String?,
    @field:Json(name = "parkNm")
    val parkNm: String?,
    @field:Json(name = "parkType")
    val parkType: String?,
    @field:Json(name = "roadNmAddr")
    val roadNmAddr: String?,
    @field:Json(name = "sggNm")
    val sggNm: String?
)