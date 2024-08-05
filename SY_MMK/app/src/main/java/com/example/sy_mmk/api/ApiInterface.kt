package com.example.sy_mmk.api


import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface ApiInterface {

    companion object {
        private const val authKey = "aiwbo1FYOvdp8hkr7wwGl3JuYGvOldXuPvNET5dL5Cdv16arcfbWAziV3CVlJWalpxIbwz2Ssl90N1bnp/wvyA=="
    }

    @GET("searchKeyword")

    fun getSearchInfo(
        @Query("serviceKey")
        serviceKey: String = authKey,

        @Query("numOfRows")
        numOfRows: Int = 10,

        @Query("pageNo")
        pageNo: Int = 1,

        @Query("MobileOS")
        mobileOS: String = "AND",

        @Query("MobileApp")
        mobileApp: String = "SY",

        @Query("_type")
        type: String = "json",

        @Query("arrange")
        arrange: String = "A",

        @Query("keyword")
        keyword: String,
    ): Call<SearchInfoResponse>
}
