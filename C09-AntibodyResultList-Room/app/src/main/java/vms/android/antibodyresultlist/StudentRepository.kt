package vms.android.antibodyresultlist

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import database.StudentDatabase
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

private const val DATABASE_NAME = "student-database"

class StudentRepository private constructor(context: Context) {

    private val database : StudentDatabase = Room.databaseBuilder(
        context.applicationContext,
        StudentDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val studentDao = database.studentDao()

    fun getStudents(): LiveData<List<Student>> = studentDao.getStudents()
    fun getStudent(id: UUID): LiveData<Student?> = studentDao.getStudent(id)

    private val executor: Executor = Executors.newFixedThreadPool(2)
    // creating a method to insert the data to our database.
    fun insert(student: Student?) {
        executor.execute { studentDao.insert(student) }
    }
    fun update(student: Student?) {
        executor.execute { studentDao.update(student)}
    }



    companion object {
        private var INSTANCE: StudentRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = StudentRepository(context)
            }
        }

        fun get(): StudentRepository {
            return INSTANCE ?:
            throw  IllegalStateException("StudentRepository must be initialized")
        }
    }

}