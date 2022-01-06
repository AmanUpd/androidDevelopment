package aman.upd.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val questionBank = listOf(
        MathQuestions(R.string.question_1, 12),
        MathQuestions(R.string.question_2, 6),
        MathQuestions(R.string.question_3, -83),
        MathQuestions(R.string.question_4, 23),
        MathQuestions(R.string.question_5, 14)
    )
    private var currentIndex = 0
    private var result = BooleanArray(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateQuestion()

        nextButton.setOnClickListener {
            nextQuestion()
        }
    }

    private fun nextQuestion() {
        if (userAnswer.text.toString().equals("")) {
            val message = getString(R.string.enterToast)
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
        else {
            var ans = userAnswer.text.toString()
            checkAnswer(ans.toInt())
            currentIndex = (currentIndex + 1)
            if (currentIndex < questionBank.size) {

                updateQuestion()
                userAnswer.text.clear()
            }
            else{
                val intent = Intent(this, ResultSummary::class.java)
//                for (i in 0..questionBank.size){
//                    result[i] = questionBank[i].correct
//                }
//
                intent.putExtra("RESULT", result)
                startActivity(intent)

            }
        }
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionText.setText(questionTextResId)
    }

    private fun checkAnswer(answer: Int) {
        val correctAnswer = questionBank[currentIndex].answer

        if (answer == correctAnswer){
            result[currentIndex]= true
        } else {
            result[currentIndex] = false
        }
    }
}