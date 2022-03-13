package com.example.asystentnauczyciela.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.viewmodel.SubjectsListAdapter
import com.example.asystentnauczyciela.viewmodel.SubjectsViewModel
import kotlinx.android.synthetic.main.fragment_zajecia.view.*

class fragmentZajecia : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var viewModel: SubjectsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_zajecia, container, false)



        val adapter = SubjectsListAdapter()
        val recyclerView = view.viewZajecia
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this).get(SubjectsViewModel::class.java)
        viewModel.getAll.observe(viewLifecycleOwner, Observer { subject->
            adapter.setData(subject)
        })


        view.actionButtonDodajZajecia.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentZajecia_to_fragmentDodawanieZajec)
        }

/*        (view.findViewById<Button>(R.id.actionButtonDodajZajecia)).setOnClickListener{

            it.findNavController().navigate(R.id.action_fragmentZajecia_to_fragmentDodawanieZajec)

        }*/

        return view
    }

    }
