package com.example.addtheminas.repository

import androidx.lifecycle.LiveData
import com.example.addtheminas.data.StudentDao
import com.example.addtheminas.model.Student

class StudentRepository (private val studentDao: StudentDao) {

    val readAllData: LiveData<List<Student>> = studentDao.readAllData()

    // Operations:::

    suspend fun addStudent(student: Student){
        studentDao.addStudent(student)
    }
    suspend fun updateStudent(student: Student){
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student){
        studentDao.deleteStudent(student)
    }

    suspend fun deleteAllStudents(){
        studentDao.deleteAllStudents()
    }

}