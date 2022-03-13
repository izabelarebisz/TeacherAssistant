package com.example.asystentnauczyciela.viewmodel

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.model.Student
import com.example.asystentnauczyciela.model.Subject
import com.example.asystentnauczyciela.view.fragmentStudenciDirections
import com.example.asystentnauczyciela.view.fragmentZajeciaDirections
import kotlinx.android.synthetic.main.one_subject_row.view.*
import kotlinx.android.synthetic.main.one_user_row.view.*

class SubjectsListAdapter: RecyclerView.Adapter<SubjectsListAdapter.MyViewHolder>()  {
    private var subjectsList = emptyList<Subject>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.one_subject_row, parent, false)
        return MyViewHolder(row)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = subjectsList[position]
        holder.itemView.nazwaTextView.text=currentItem.nazwa
        holder.itemView.dzienTygTextView.text=currentItem.dzien_tyg
        holder.itemView.godzinaTextView1.text=currentItem.od_kiedy
        holder.itemView.godzinaTextView2.text=currentItem.do_kiedy

        holder.itemView.rowSubject.setOnClickListener {
            val action = fragmentZajeciaDirections.actionFragmentZajeciaToFragmentEdytowanieZajec(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return subjectsList.size
    }

    fun setData(subject: List<Subject>){
        this.subjectsList = subject
        notifyDataSetChanged()
    }
}