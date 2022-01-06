package aman.upd.oceanlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detail = intent.getStringExtra("detail")
        detailView.setText(detail)

        val name = intent.getStringExtra("name")
        nameView.setText(name)

        val image = intent.getIntExtra("image",0)
        imageView.setImageResource(image)
    }
}