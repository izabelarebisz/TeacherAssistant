package com.example.asystentnauczyciela.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.asystentnauczyciela.viewmodel.StudentsViewModel
import com.example.asystentnauczyciela.viewmodel.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_studenci.view.*
import com.example.asystentnauczyciela.R


class fragmentStudenci : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var viewModel: StudentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_studenci, container, false)

        val adapter = StudentsListAdapter()
        val recyclerView = view.viewStudenci
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this).get(StudentsViewModel::class.java)
        viewModel.getAll.observe(viewLifecycleOwner, Observer { student->
            adapter.setData(student)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStudenci_to_fragmentDodawanieStudenta)
        }



        return view
    }

}
