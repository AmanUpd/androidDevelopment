package aman.upd.finalexam_cinemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import api.MovieResponse
import api.MoviesApi
import api.MoviesResponse_base
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movies_item_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val REQUEST_CODE_SECONDACT = 101
class MainActivity : AppCompatActivity() {
//    private val r_movies: MoviesResponse_base = MoviesResponse_base()
var favliststore = mutableListOf<Array<String>>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movies_list.layoutManager = LinearLayoutManager(this)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.majorcineplex.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val movieApi: MoviesApi = retrofit.create(MoviesApi::class.java)
        val getMoviesRequest: Call<MoviesResponse_base> = movieApi.getMovies()

        var movies_list_sample : List<MovieResponse>

        getMoviesRequest.enqueue(object: Callback<MoviesResponse_base>{
            override fun onResponse(call: Call<MoviesResponse_base>, response: Response<MoviesResponse_base>) {
                var movieResponse = response.body()
                if (movieResponse != null) {
                    movies_list_sample = movieResponse.movies
                    movies_list.adapter = MoviesAdapter(movies_list_sample)
                    Log.d("MOVIE-API", movieResponse.toString())
                }
            }
            override fun onFailure(call: Call<MoviesResponse_base>, t: Throwable) {
                Log.e("MOVIES-API","FAILED TO REQUEST!")
            }

        })

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode != Activity.RESULT_OK){
            return
        }
        if (requestCode == REQUEST_CODE_SECONDACT){
           if (data != null) {
               data.getStringArrayExtra("FAV")?.let { favliststore.add(it) }
               Log.d("ARRAYCALLBACK",favliststore.toString())
           }
            else{
               Log.e("ARRAYCALLBACK","CAL BACK FAILED")
            }
        }

    }
    private inner class MovieHolder(view: View): RecyclerView.ViewHolder(view){
        var movie_genre: TextView = itemView.findViewById(R.id.text_genre)
        var movie_title: TextView = itemView.findViewById(R.id.text_name)
        var movie_date: TextView = itemView.findViewById(R.id.text_date)
        var movie_image: ImageView = itemView.findViewById(R.id.image_movie)
        var movie_viewmore: TextView = itemView.findViewById(R.id.text_viewmore)
    }
    private inner class MoviesAdapter(var movie: List<MovieResponse>): RecyclerView.Adapter<MovieHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
            val view = layoutInflater.inflate(R.layout.movies_item_list,parent,false)
            return MovieHolder(view)
        }

        override fun onBindViewHolder(holder: MovieHolder, position: Int) {

            holder.apply {
                movie_title.text =  movie[position].title_en
                movie_date.text = movie[position].release_date
                movie_genre.text = movie[position].genre
                Picasso.get().load(movie[position].poster_url).into(movie_image)


                movie_viewmore.setOnClickListener{
                    val intent = Intent(itemView.context, SecondActivity::class.java)
                    intent.putExtra("GENRE",movie[position].genre)
                    intent.putExtra("NAME",movie[position].title_en)
                    intent.putExtra("DETAIL", movie[position].synopsis_en)
                    intent.putExtra("IMAGE",movie[position].poster_url)
                    intent.putExtra("DATE",movie[position].release_date)
                    startActivityForResult(intent, REQUEST_CODE_SECONDACT)
                }
            }
        }


        override fun getItemCount(): Int {
            return movie.size
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.favoption){
            Log.d("MENU", "Favourite Clicked")
            val intent3 = Intent(this, FavActivity::class.java)
            intent3.putExtra("FAVOURITELIST",ArrayList(favliststore))
            startActivity(intent3)
        }
        return super.onOptionsItemSelected(item)
    }


}