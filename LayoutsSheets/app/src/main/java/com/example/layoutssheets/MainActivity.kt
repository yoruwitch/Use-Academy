package com.example.layoutssheets

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.layoutssheets.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomSheet = binding.bottomSheetInclude.root


        /*Button that activates the Bottom Sheet*/

        binding.btnBottomSheet.setOnClickListener {
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        /*Button that activates the simple dialog alert*/

        binding.btnDialog.setOnClickListener {
            dialogSimple()
        }

        binding.btnCustomDialog.setOnClickListener {
            myDialogCustom()
        }
    }

    /*Function that coordinates all activities behind the click on the dialog alert*/

    private fun dialogSimple() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this).also {
            it.setTitle("This is an alert!")
            it.setMessage("Is this exercise correct?")
            it.setPositiveButton("Sure!", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "Thank you so much!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        }
        builder.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "I'm sorry, I'm gonna improve!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        builder.setNeutralButton("I dunno", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "What can I do to change your opinion?",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        builder.create().show()
    }

    /*Function that creates the custom dialog and its actions*/

    private fun myDialogCustom() {
        val view: View = layoutInflater.inflate(R.layout.custom_dialog, null)
        val builder = AlertDialog.Builder(this).also {
            it.setTitle("Custom Dialog")
            it.setView(view)
        }
        val alert = builder.create()
        view.findViewById<Button>(R.id.btnOk).setOnClickListener {
            Toast.makeText(
                this@MainActivity,
                "It's closed!",
                Toast.LENGTH_SHORT
            ).show()
            alert.dismiss()
        }
        alert.show()
    }
}
