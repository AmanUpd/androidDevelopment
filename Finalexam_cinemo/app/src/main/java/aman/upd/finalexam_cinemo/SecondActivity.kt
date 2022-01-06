package aman.upd.finalexam_cinemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.movies_item_list.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val image = intent.getStringExtra("IMAGE")
        val genre = intent.getStringExtra("GENRE")
        val name = intent.getStringExtra("NAME")
        val detail = intent.getStringExtra("DETAIL")
        val date = intent.getStringExtra("DATE")
        val addtofav = arrayOf(image.toString(), name.toString(), genre.toString(), detail.toString(),date.toString())
        text_namesecond.text =  name
        text_genresecond.text = genre
        text_detailsecond.text = detail
        Picasso.get().load(image).into(image_moviesecond)

        button_fav.setOnClickListener {
            val intent2 = Intent()
                intent2.putExtra("FAV",addtofav)
            setResult(Activity.RESULT_OK,intent2)
        }
    }
}

