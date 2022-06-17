package com.example.addtheminas.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.addtheminas.R
import com.example.addtheminas.model.Student
import com.example.addtheminas.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)

        //updates the values already entered in:::

        view.et_name_update.setText(args.currentStudent.firstName)
        view.et_last_name_update.setText(args.currentStudent.lastname)
        view.et_number_update.setText(args.currentStudent.age.toString())

        view.btn_update.setOnClickListener {
            updateItem()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val firstName = et_name_update.text.toString()
        val lastName = et_last_name_update.text.toString()
        val age = Integer.parseInt(et_number_update.text.toString())


        // validation::

        if (validation(firstName, lastName, et_number_update.text)) {

            val updatedStudent = Student(args.currentStudent.id, firstName, lastName, age)
            mStudentViewModel.updateStudent(updatedStudent)

            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun validation(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    // this function inflates the menu on the screen:::

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.btn_delete) {
            deleteStudent()
        }
        return super.onOptionsItemSelected(item)
    }

    // Dialog alert for deleting user::

    private fun deleteStudent() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mStudentViewModel.deleteStudent(args.currentStudent)

            Toast.makeText(
                requireContext(),
                "Deleted student: ${args.currentStudent.firstName}",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate((R.id.action_updateFragment_to_listFragment))
        }

        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete the student ${args.currentStudent.firstName} ?")
        builder.setMessage("Are you sure you want to delete this student?")

        builder.create().show()
    }

}