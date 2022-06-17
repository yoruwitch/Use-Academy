package com.example.addtheminas.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

// Set the entity class with the students data:::

@Parcelize
@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastname: String,
    val age: Int
) : Parcelable
