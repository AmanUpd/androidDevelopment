package aman.upd.c06list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.student_item_list.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        student_list.layoutManager = LinearLayoutManager(this)

        val student = sampleStudent()
        student_list.adapter = StudentAdapter(student)
    }
    private fun sampleStudent() : List<Student>{
        val students = mutableListOf<Student>()
        for (i in 1 until 100){
            val student = Student()
            student.name = "Student ${i}"
            student.testResult = (1..2).random() % 2 == 0
            students+= student
        }
        return students
    }
    private inner class StudentHolder(view: View): RecyclerView.ViewHolder(view){
        val studentID = itemView.StudentID
        val studentName = itemView.studentName
        val testResult = itemView.studentTest
    }

    private inner class StudentAdapter(var student: List<Student>): RecyclerView.Adapter<StudentHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
            val view = layoutInflater.inflate(R.layout.student_item_list,parent,false)
            return StudentHolder(view)
        }

        override fun onBindViewHolder(holder: StudentHolder, position: Int) {
            val student = student[position]
            holder.apply {
                studentName.text = student.name
                testResult.text = if (student.testResult) "POSITIVE" else "NEGATIVE"
            }

        }

        override fun getItemCount(): Int {
            return student.size
        }

    }
}