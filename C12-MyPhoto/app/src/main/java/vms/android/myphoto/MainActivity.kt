package vms.android.myphoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.content.Intent
import android.provider.MediaStore
import androidx.core.app.ActivityCompat.startActivityForResult
import android.graphics.Bitmap

import android.app.Activity
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ActivityCompat.startActivityForResult
import android.graphics.BitmapFactory




class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST = 1888
    private val PICK_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.activity_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.editDateItem) {
            Log.d("MENU", "Edit Date Clicked")
            DatePickerFragment().show(this@MainActivity.supportFragmentManager, "DATEPICKER")
        }
        if(item.itemId == R.id.editcamera){
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val result = startActivityForResult (cameraIntent, CAMERA_REQUEST)
        }
        if(item.itemId == R.id.editgallery){
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == CAMERA_REQUEST && data != null){
            imageView.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_IMAGE && data != null) {
            imageView.setImageURI(data.data)
        }
    }




}

