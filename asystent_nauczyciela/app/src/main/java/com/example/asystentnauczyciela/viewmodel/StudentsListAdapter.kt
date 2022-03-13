package com.example.asystentnauczyciela.viewmodel

import android.text.Layout
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.model.*
import com.example.asystentnauczyciela.view.fragmentStudenciDirections
import kotlinx.android.synthetic.main.one_user_row.view.*


class StudentsListAdapter: RecyclerView.Adapter<StudentsListAdapter.MyViewHolder>() {

    private var studentsList = emptyList<Student>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.one_user_row, parent, false)
        return MyViewHolder(row)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentsList[position]
        holder.itemView.imieTextView.text=currentItem.imie
        holder.itemView.nazwiskoTextView.text=currentItem.nazwisko


        holder.itemView.rowStudent.setOnClickListener {
            val action = fragmentStudenciDirections.actionFragmentStudenciToFragmentEdytowanieStudenta(currentItem)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return studentsList.size
    }

    fun setData(student: List<Student>){
        this.studentsList = student
        notifyDataSetChanged()
    }

}


