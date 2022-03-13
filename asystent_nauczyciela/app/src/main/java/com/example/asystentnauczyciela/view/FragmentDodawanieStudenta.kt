package com.example.asystentnauczyciela.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.viewmodel.StudentsViewModel
import com.example.asystentnauczyciela.model.Student
import kotlinx.android.synthetic.main.fragment_dodawanie_studenta.*
import kotlinx.android.synthetic.main.fragment_dodawanie_studenta.view.*


class FragmentDodawanieStudenta : Fragment() {
    private lateinit var viewModel: StudentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dodawanie_studenta, container, false)

        viewModel = ViewModelProvider(this).get(StudentsViewModel::class.java)

        view.findViewById<Button>(R.id.dodaj_studenta).setOnClickListener {
            insertData()
        }

      /*  view.test.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentDodawanieStudenta_to_fragmentDodawanieZajec)
        }*/

        return view
    }

    private fun insertData(){
        val imie = wczytaj_imie.text.toString()
        val nazwisko = wczytaj_nazwisko.text.toString()

        val student = Student(0,imie,nazwisko)
        viewModel.insert(student)
        Toast.makeText(requireContext(),"Dodano pomyślnie", Toast.LENGTH_LONG).show()
    }
}