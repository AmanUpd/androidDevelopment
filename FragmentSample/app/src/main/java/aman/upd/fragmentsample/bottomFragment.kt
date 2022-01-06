package aman.upd.fragmentsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_bottom.*

class bottomFragment: Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom,container,false)
        return view

    }
    override fun onStart() {
        super.onStart()
        button.setOnClickListener {
            Toast.makeText(activity, "click from bottom fragment ", Toast.LENGTH_SHORT).show()
        }
    }
}