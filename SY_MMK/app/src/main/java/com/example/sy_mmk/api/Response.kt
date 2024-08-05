package com.example.sy_mmk.api

data class SearchInfoResponse(
    val response: Response
)

data class Response(
    val body: Body
)

data class Body(
    val items: Items
)

data class Items(
    val item: List<TouristInfo>
)

data class TouristInfo(
    val addr1: String,          // 주소
    val addr2: String?,         // 상세 주소
    val firstimage: String,     // 대표 사진
    val modifiedtime: String,   // 최근 수정일
    val title: String           // 관광지 명
)