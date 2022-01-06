package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentList = ArrayList<Student>()
        studentList.add(Student(RecyclerViewAdapter.VIEW_TYPE_ONE, 1, "Lincoln", "4.00", "0"))
        studentList.add(Student(RecyclerViewAdapter.VIEW_TYPE_TWO, 2, "Sammy", "1.80", "33"))
        studentList.add(Student(RecyclerViewAdapter.VIEW_TYPE_THREE, 3, "Pinky", "3.80", "94"))
        studentList.add(Student(RecyclerViewAdapter.VIEW_TYPE_THREE, 4, "Cam", "3.65", "68"))

        val adapter = RecyclerViewAdapter(this, studentList)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}