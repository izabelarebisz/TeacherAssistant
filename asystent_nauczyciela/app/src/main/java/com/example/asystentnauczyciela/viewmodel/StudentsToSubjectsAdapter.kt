package com.example.asystentnauczyciela.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.model.Subject
import kotlinx.android.synthetic.main.one_sub_stu_row.view.*


class StudentsToSubjectsAdapter: RecyclerView.Adapter<StudentsToSubjectsAdapter.MyViewHolder>() {
    private var subStuList = emptyList<Subject>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.one_sub_stu_row, parent, false)
        return MyViewHolder(row)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = subStuList[position]
        holder.itemView.przedmiot.text=currentItem.nazwa

        holder.itemView.rowStuSub.setOnClickListener {

        }
    }

    override fun getItemCount(): Int {
        return subStuList.size
    }

    fun setData(subject: List<Subject>){
        this.subStuList= subject
        notifyDataSetChanged()
    }

}