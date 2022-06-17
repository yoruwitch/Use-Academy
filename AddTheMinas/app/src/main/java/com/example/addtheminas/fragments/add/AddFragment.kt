package com.example.addtheminas.fragments.add

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.addtheminas.R
import com.example.addtheminas.model.Student
import com.example.addtheminas.viewmodel.StudentViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        // sets up the provider from the ViewModel

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        view.btn_add.setOnClickListener {
            insertInfoToDatabase()
        }
        return view
    }

    // responsible for getting the input data:::

    private fun insertInfoToDatabase() {
        val firstName = etName.text.toString()
        val lastName = etLastName.text.toString()
        val age = etNumber.text

        if (validation(firstName, lastName, age)) {

            val student = Student(0, firstName, lastName, Integer.parseInt(age.toString()))
            mStudentViewModel.addStudent(student)

            val snackbar =
                view?.let { Snackbar.make(it, "Successfully added!", Snackbar.LENGTH_LONG) }
            snackbar?.setBackgroundTint(Color.GREEN)
            snackbar?.show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            val snackbar =
                view?.let { Snackbar.make(it, "Fields need to be filled", Snackbar.LENGTH_LONG) }
            snackbar?.setBackgroundTint(Color.RED)
            snackbar?.show()
        }

    }

    // validation to our inputs:::

    private fun validation(
        firstName: String, lastName: String, age: Editable
    ): Boolean {
        return !(
                TextUtils.isEmpty(firstName) and TextUtils.isEmpty(lastName) and
                        age.isEmpty()
                )
    }
}