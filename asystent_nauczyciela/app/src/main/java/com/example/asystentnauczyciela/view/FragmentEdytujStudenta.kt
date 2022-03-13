package com.example.asystentnauczyciela.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.model.Student
import com.example.asystentnauczyciela.viewmodel.SharedViewModel
import com.example.asystentnauczyciela.viewmodel.StudentsViewModel
import kotlinx.android.synthetic.main.fragment_edytowanie_studenta.*
import kotlinx.android.synthetic.main.fragment_edytowanie_studenta.view.*

class FragmentEdytujStudenta : Fragment() {

    private val args by navArgs<FragmentEdytujStudentaArgs>()

    private lateinit var viewModel: StudentsViewModel

    private val sharedViewModel: SharedViewModel by activityViewModels<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edytowanie_studenta, container, false)


        viewModel = ViewModelProvider(this).get(StudentsViewModel::class.java)

        view.edytuj_imie.setText(args.currentStudent.imie)
        view.edytuj_nazwisko.setText(args.currentStudent.nazwisko)

        view.edytuj_studenta.setOnClickListener{
            updateItem()
        }

        view.usun_studenta.setOnClickListener{
            deleteItem()
        }

        view.usun_wszystko.setOnClickListener{
            deleteItems()
        }

        view.dodajPrzedmiotyDoStudenta.setOnClickListener{
            sharedViewModel.setValue(args.currentStudent.user_id)
            findNavController().navigate(R.id.action_fragmentEdytowanieStudenta_to_fragmentZajeciaDoPrzypisania)

        }


        return view
    }

    private fun updateItem(){
        val imie = edytuj_imie.text.toString()
        val nazwisko = edytuj_nazwisko.text.toString()

        val new = Student(args.currentStudent.user_id,imie,nazwisko)

        //update w view modelu
        viewModel.update(new)
        Toast.makeText(requireContext(),"Zakończono pomyślnie", Toast.LENGTH_LONG).show()
    }

    private fun deleteItem(){
        //viewModel.delete(args.currentStudent)
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Tak"){ _, _ ->
            viewModel.delete(args.currentStudent)
            Toast.makeText(requireContext(),"Usunięto", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("Nie"){ _, _ ->}
        builder.setMessage("Czy na pewno chcesz usunąć?")

        builder.create().show()



    }

    private fun deleteItems(){
        //viewModel.delete(args.currentStudent)
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Tak"){ _, _ ->
            viewModel.deleteAll()
            Toast.makeText(requireContext(),"Usunięto", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("Nie"){ _, _ ->}
        builder.setMessage("Czy na pewno chcesz usunąć wszystkich studentów?")

        builder.create().show()



    }

}

