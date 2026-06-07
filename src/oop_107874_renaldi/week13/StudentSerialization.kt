package oop_107874_renaldi.week13

import java.io.File
import java.io.FileNotFoundException

data class Student(val name: String, val age: Int, val gpa: Double)

fun Student.toCsv(): String = "$name,$age,$gpa"


fun fromCsv(line: String): Student {
    val parts = line.split(delimiters = ",")
    return Student(name = parts[0], age = parts[1].toInt(), gpa = parts[2].toDouble())

    fun saveStudents(students: List<Student>, path: String) {
        File(pathname = path).writeText(students.joinToString(separator = "\n") { it.toCsv() })
    }

    fun loadStudents(path: String): List<Student> {
        return try {
            File(pathname = path).readLines().map { fromCsv(line = it) }
        } catch (e: FileNotFoundException) {
            println("Error: File tidak ditemukan!")
            emptyList()
        }
    }
}
