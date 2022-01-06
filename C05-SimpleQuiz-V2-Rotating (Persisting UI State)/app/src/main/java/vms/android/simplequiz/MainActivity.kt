package vms.android.simplequiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

private const val REQUEST_CODE_SECONDACT = 101

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val KEY_INDEX = "index"
    private val KEY_CHEAT = "Cheater"

    private val questionViewModel: QuestionViewModel by lazy {
        ViewModelProvider(this).get(QuestionViewModel::class.java)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState called")

        outState.putInt(KEY_INDEX, questionViewModel.currentIndex)
        outState.putBoolean(KEY_CHEAT, questionViewModel.currentQuestionIntegrity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate() called")

        val currentIndex: Int = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        questionViewModel.currentIndex = currentIndex

        val currentIntegrity: Boolean = savedInstanceState?.getBoolean(KEY_CHEAT, false) ?: false
        questionViewModel.setAssist(currentIntegrity)

        updateQuestion()

        cheatButton.setOnClickListener {
            val intent = Intent(this,CheatActivity::class.java)
            val pass = questionViewModel.currentQuestionAnswer
            intent.putExtra("PASS",pass)
            startActivityForResult(intent, REQUEST_CODE_SECONDACT )

        }
        yesButton.setOnClickListener {
            checkAnswer(true)
        }

        noButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            nextQuestion()
        }

        displayedQuestion.setOnClickListener {
            nextQuestion()
        }

        previousButton.setOnClickListener {
            questionViewModel.moveToPreviousQuestion()
            updateQuestion()
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode != Activity.RESULT_OK){
            return
        }
        if(requestCode == REQUEST_CODE_SECONDACT){
            val assisted = data?.getBooleanExtra("CHEAT",false)
            if (assisted != null) {
                questionViewModel.setAssist(assisted)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy() called")
    }


    private fun nextQuestion() {
        questionViewModel.moveToNextQuestion()
        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = questionViewModel.currentQuestionText
        displayedQuestion.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionViewModel.currentQuestionAnswer
        val integrityCheck = questionViewModel.currentQuestionIntegrity

        if (integrityCheck){
            var msg =  "Cheating is wrong!!"
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
        else {
            var messageResId = if (userAnswer == correctAnswer) {
                R.string.correct_toast
            } else {
                R.string.incorrect_toast
            }
            Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show()
        }


    }

}