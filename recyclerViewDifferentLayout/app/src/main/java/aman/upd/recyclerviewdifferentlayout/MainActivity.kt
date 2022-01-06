package aman.upd.recyclerviewdifferentlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.student_list.*
import kotlinx.android.synthetic.main.student_list.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        honorStudent.layoutManager = LinearLayoutManager(this)
        val honorsS = honorall()
        honorStudent.adapter = StudentAdapter(honorsS)

        normalStudent.layoutManager = LinearLayoutManager(this)
        val normS = normalall()
        honorStudent.adapter = StudentAdapter(normS)

        probationStudent.layoutManager = LinearLayoutManager(this)
        val probationS = probationall()
        probationStudent.adapter = StudentAdapter(probationS)


    }
    private fun honorall():List<student>{
        val Hstu = mutableListOf<student>()

        val HA = student(6111111,"HA",3.56,120)
        val HB = student(6111112,"HB",3.57,150)
        val HC = student(6111113,"HC",3.60,50)
        val HD = student(6111114,"HD",3.90,80)
        val HE = student(6111115,"HE",3.99,95)

        Hstu += HA
        Hstu += HB
        Hstu += HC
        Hstu += HD
        Hstu += HE

        return Hstu
    }
    private fun normalall():List<student>{
        val Nstu = mutableListOf<student>()

        val NA = student(6000001,"NA",3.30,110)
        val NB = student(6000002,"NB",3.35,142)
        val NC = student(6000003,"NC",3.40,71)
        val ND = student(6000004,"ND",3.45,99)
        val NE = student(6000005,"NE",3.49,105)

        Nstu += NA
        Nstu += NB
        Nstu += NC
        Nstu += ND
        Nstu += NE

        return Nstu
    }
    private fun probationall():List<student>{
        val Nstu = mutableListOf<student>()

        val NA = student(5999991,"PA",2.20,115)
        val NB = student(5999992,"PB",2.10,133)
        val NC = student(5999993,"PC",2.03,91)
        val ND = student(5999994,"PD",2.01,99)
        val NE = student(5999995,"PE",2.12,101)

        Nstu += NA
        Nstu += NB
        Nstu += NC
        Nstu += ND
        Nstu += NE

        return Nstu
    }
    private inner class StudentHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sname = itemView.name
        val sid = itemView.Sid
        val sgpa = itemView.gpa
        val scre = itemView.credits

        lateinit var stu: student

        fun bind(students: student){
            this.stu = students
            sname.text = stu.name
            sid.text = stu.studentid.toString()
            sgpa.text = stu.gpa.toString()
            scre.text = stu.credits.toString()

        }

    }
    private inner class StudentAdapter(var student:List<student>): RecyclerView.Adapter<StudentHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
            val view = layoutInflater.inflate(R.layout.student_list,parent, false)
            return StudentHolder(view)
        }

        override fun onBindViewHolder(holder: StudentHolder, position: Int) {
            val students = student[position]
            holder.bind(students)
        }

        override fun getItemCount(): Int {
            return student.size
        }
    }
}