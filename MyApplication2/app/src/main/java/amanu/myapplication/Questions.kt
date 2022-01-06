package amanu.myapplication

import androidx.annotation.StringRes

//class Questions {
//
//    var questionText: String = ""
//    var answer: Boolean = false
//
//}
data class Question(@StringRes val textResId: Int, val answer: Boolean)
{

}