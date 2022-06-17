package com.example.addtheminas.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.addtheminas.R
import com.example.addtheminas.model.Student
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var studentList = emptyList<Student>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.custom_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //getting each item from the Student class and linking them to the recycler view correspondent

        val currentItem = studentList[position]
        holder.itemView.number.text = currentItem.id.toString()
        holder.itemView.tv_first_name.text = currentItem.firstName
        holder.itemView.tv_last_name.text = currentItem.lastname
        holder.itemView.tv_age.text = currentItem.age.toString()

        holder.itemView.row_layout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun setData(student: List<Student>){
        this.studentList = student
        notifyDataSetChanged()
    }
}