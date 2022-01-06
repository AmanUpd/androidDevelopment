package api

import com.google.gson.annotations.SerializedName

data class MoviesResponse_base(
    @SerializedName("movies") val movies : List<MovieResponse>
)
