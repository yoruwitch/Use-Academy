package com.example.addtheminas.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.addtheminas.model.Student

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("DELETE FROM student_table")
     fun deleteAllStudents()

    @Query("SELECT * FROM student_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Student>>

}