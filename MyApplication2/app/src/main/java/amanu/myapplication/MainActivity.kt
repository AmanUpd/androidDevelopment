package amanu.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val questionBank = listOf(  Question(R.string.question_1,true),
                                        Question(R.string.question_2,true),
                                        Question(R.string.question_3,false),
                                        Question(R.string.question_4,false),
                                        Question(R.string.question_5,false),
                                        Question(R.string.question_6,true),
                                        Question(R.string.question_7,false),
                                        Question(R.string.question_8,false),
                                        Question(R.string.question_9,true),
                                        Question(R.string.question_10,false))
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateQuestion()

        displayedQuestion.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        yesButton.setOnClickListener{
            checkAnswer(true)
        }
        noButton.setOnClickListener {
            checkAnswer(false)
        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        prevButton.setOnClickListener {
            currentIndex = (currentIndex - 1)
            if (currentIndex < 0){
                currentIndex = questionBank.size - 1
            }
            updateQuestion()
        }

    }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        displayedQuestion.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer:Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

//        if (userAnswer == correctAnswer) {
//            Toast.makeText(this, R.string.correctToast,Toast.LENGTH_LONG).show()
//        } else {
//            Toast.makeText(this, R.string.incorrectToast,Toast.LENGTH_LONG).show()
//        }

        var messageResId = if (userAnswer == correctAnswer){
                                R.string.correctToast
                            } else {
                                 R.string.incorrectToast
                            }

        Toast.makeText(this, messageResId,Toast.LENGTH_LONG).show()
    }
}