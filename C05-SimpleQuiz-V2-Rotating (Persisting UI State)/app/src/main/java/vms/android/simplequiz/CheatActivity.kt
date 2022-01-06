package vms.android.simplequiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_cheat.*
import kotlinx.android.synthetic.main.activity_main.*

class CheatActivity : AppCompatActivity() {

    private val KEY_CHEATER = "Cheater"
    private var cheated = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        cheated = savedInstanceState?.getBoolean(KEY_CHEATER, false) ?: false
        val ans = intent.getBooleanExtra("PASS",true)

       confirmbutton.setOnClickListener {
            var YN = "No"

            if (ans == true){
                YN = "Yes"
            }


            answerText.setText("The answer is ${YN}")
            cheated = true


            val data = Intent()
            data.putExtra("CHEAT",cheated)
            setResult(Activity.RESULT_OK,data)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_CHEATER, cheated )
    }

}