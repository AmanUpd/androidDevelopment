package api

import retrofit2.Call
import retrofit2.http.GET

interface MoviesApi {
    @GET("/")
    fun getSample(): Call<String>

    @GET("apis/get_movie_avaiable")
    fun getMovies(): Call<MoviesResponse_base>
}