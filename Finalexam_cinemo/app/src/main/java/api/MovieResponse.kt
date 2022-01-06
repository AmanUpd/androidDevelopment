package api

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    @SerializedName("id") val id : Int,
    @SerializedName("title_en") val title_en : String,
    @SerializedName("release_date") val release_date : String,
    @SerializedName("synopsis_en") val synopsis_en : String,
    @SerializedName("genre") val genre : String,
    @SerializedName("poster_url") val poster_url : String,

)
