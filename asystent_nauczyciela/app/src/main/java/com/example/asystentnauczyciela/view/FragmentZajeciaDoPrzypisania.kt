package com.example.asystentnauczyciela.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.model.AppDatabase
import com.example.asystentnauczyciela.studentsToSubjects.StudentToSubjectDao
import com.example.asystentnauczyciela.viewmodel.*
import kotlinx.android.synthetic.main.fragment_studenci.view.*
import kotlinx.android.synthetic.main.fragment_studenci.view.viewStudenci
import kotlinx.android.synthetic.main.fragment_zajecia_do_przypisania.view.*

class FragmentZajeciaDoPrzypisania : Fragment() {
    private lateinit var viewModel: StudentsToSubjectsViewModel

    private val sharedViewModel: SharedViewModel by activityViewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_zajecia_do_przypisania, container, false)

        viewModel = ViewModelProvider(this).get(StudentsToSubjectsViewModel::class.java)

        val id = sharedViewModel.whichValue()
        if (id != null) {
            viewModel.actualizeId(id)
        }
        val adapter = StudentsToSubjectsAdapter()
        val recyclerView = view.viewPrzedmiotyPrzypisane
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.getAll.observe(viewLifecycleOwner, Observer { subject->
            adapter.setData(subject)
        })




        return view
    }

}