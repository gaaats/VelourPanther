package com.gamegou.footbally

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET("json/?key=KXgMIA7HSEcn0SV")
    suspend fun getData(): Response<CountryCodeJS>

    @GET("const.json")
    suspend fun getDataDev(): Response<GeoDev>
}
@Keep
data class CountryCodeJS(
    @SerializedName("city")
    val fgtgtgttg: String,
    @SerializedName("country")
    val gthy: String,
    @SerializedName("countryCode")
    val frfrrr: String,
)
@Keep
data class GeoDev(
    @SerializedName("geo")
    val hjpupjp: String,
    @SerializedName("view")
    val viewtgtttg: String,
    @SerializedName("appsChecker")
    val frrrrr: String,
)