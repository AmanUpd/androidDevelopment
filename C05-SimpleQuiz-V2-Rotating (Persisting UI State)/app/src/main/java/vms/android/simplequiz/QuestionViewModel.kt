package vms.android.simplequiz

import android.util.Log
import androidx.lifecycle.ViewModel

//private const val TAG = "QuestionViewModel"

class QuestionViewModel: ViewModel() {

    private val questionBank = listOf(  Question(R.string.question_1, true,false),
        Question(R.string.question_2, true,false),
        Question(R.string.question_3, false,false),
        Question(R.string.question_4, false,false),
        Question(R.string.question_5, false,false),
        Question(R.string.question_6, true,false),
        Question(R.string.question_7, false,false),
        Question(R.string.question_8, false,false),
        Question(R.string.question_9, true,false),
        Question(R.string.question_10, false,false))

    var currentIndex = 0
    var assisted = false
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionIntegrity: Boolean
        get() = questionBank[currentIndex].cheating

    fun moveToNextQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPreviousQuestion() {
        if (currentIndex == 0) {
            currentIndex = questionBank.size
        }

        currentIndex = (currentIndex - 1) % questionBank.size
    }
    fun setAssist(inp: Boolean){
        questionBank[currentIndex].cheating = inp
    }

//    init {
//        Log.d(TAG, "ViewModel instance created")
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//
//        Log.d(TAG, "ViewModel instance about to be cleared")
//    }

}