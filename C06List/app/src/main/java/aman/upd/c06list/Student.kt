package aman.upd.c06list

import java.util.*

data class Student(val id : UUID = UUID.randomUUID(),
                    var name: String = "",
                    var testResult:Boolean = false){

}