package vms.android.simplequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(  Question(R.string.question_1, true),
                                        Question(R.string.question_2, true),
                                        Question(R.string.question_3, false),
                                        Question(R.string.question_4, false),
                                        Question(R.string.question_5, false),
                                        Question(R.string.question_6, true),
                                        Question(R.string.question_7, false),
                                        Question(R.string.question_8, false),
                                        Question(R.string.question_9, true),
                                        Question(R.string.question_10, false))
    private var currentIndex = 0

    private var totalScore = 0
    private var totalAnswered = 0


    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate() called")

        updateQuestion()

        yesButton.setOnClickListener {
            yesButton.isEnabled = false
            noButton.isEnabled = false
            questionBank[currentIndex].answered = true

            checkAnswer(true)
        }

        noButton.setOnClickListener {
            yesButton.isEnabled = false
            noButton.isEnabled = false
            questionBank[currentIndex].answered = true

            checkAnswer(false)
        }

        nextButton.setOnClickListener {

            nextQuestion()
            val res = questionBank[currentIndex].answered
            yesButton.isEnabled = !res
            noButton.isEnabled = !res
        }

//        displayedQuestion.setOnClickListener {
//            nextQuestion()
//        }

        previousButton.setOnClickListener {

            if (currentIndex == 0) {
                currentIndex = questionBank.size
            }

            currentIndex = (currentIndex - 1) % questionBank.size
            updateQuestion()
            val res = questionBank[currentIndex].answered
            yesButton.isEnabled = !res
            noButton.isEnabled = !res
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
        currentIndex = (currentIndex + 1) % questionBank.size
        updateQuestion()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        displayedQuestion.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        if (userAnswer == correctAnswer) {
            totalScore += 1
        }
        totalAnswered += 1

        var messageResId =  if (userAnswer == correctAnswer) {
                                R.string.correct_toast
                            } else {
                                R.string.incorrect_toast
                            }

        if (totalAnswered == questionBank.size){
            val per = (totalScore * 100) /totalAnswered
            val message = getString((R.string.scoreToast),per)
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }



}