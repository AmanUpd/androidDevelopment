package aman.upd.finalexam_cinemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import api.MovieResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_fav.*

class FavActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav)
        val favlistfinal = intent.getStringArrayListExtra("FAVOURITELIST") as  List<Array<String>>

//        val favlistfinal = intent.getStringArrayExtra("FAVOURITELIST")
        fav_list.layoutManager = LinearLayoutManager(this)
        fav_list.adapter = FavAdapter(favlistfinal)

    }
    private inner class FavHolder(view: View): RecyclerView.ViewHolder(view){
        var movie_genre: TextView = itemView.findViewById(R.id.text_genre)
        var movie_title: TextView = itemView.findViewById(R.id.text_name)
        var movie_date: TextView = itemView.findViewById(R.id.text_date)
        var movie_image: ImageView = itemView.findViewById(R.id.image_movie)
        var movie_viewmore: TextView = itemView.findViewById(R.id.text_viewmore)
    }

    private inner class FavAdapter(var favourites: List<Array<String>>): RecyclerView.Adapter<FavHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavHolder {
            val view = layoutInflater.inflate(R.layout.movies_item_list,parent,false)
            return FavHolder(view)
        }

        override fun onBindViewHolder(holder:FavHolder, position: Int) {
            val favo = favourites[position]
            holder.apply {
                movie_title.text =  favo[1]
                movie_date.text = favo[4]
                movie_genre.text = favo[2]
                Picasso.get().load(favo[0]).into(movie_image)

            }

        }

        override fun getItemCount(): Int {
            return favourites.size
        }

    }
}