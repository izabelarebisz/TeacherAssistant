package com.example.asystentnauczyciela.view

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.model.*
import com.example.asystentnauczyciela.viewmodel.SubjectsViewModel
import kotlinx.android.synthetic.main.fragment_edytowanie_zajec.*
import kotlinx.android.synthetic.main.fragment_edytowanie_zajec.view.*


class FragmentEdytowanieZajec : Fragment() {

    private val args by navArgs<FragmentEdytowanieZajecArgs>()

    private lateinit var viewModel: SubjectsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_edytowanie_zajec, container, false)
/*

        viewModel = ViewModelProvider(this).get(SubjectsViewModel::class.java)



        view.edytuj_przedmiot.setText(args.currentSubject.nazwa)
        view.edytuj_godzinaOd.setText(args.currentSubject.godzinaOd)
        view.edytuj_minutaOd.setText(args.currentSubject.minutaOd)
        view.edytuj_godzinaDo.setText(args.currentSubject.godzinaDo)
        view.edytuj_minutaDo.setText(args.currentSubject.minutaDo)


        view.edytuj_zajecia.setOnClickListener{
            updateItem()
        }

        view.usun_zajecia.setOnClickListener{
            deleteItem()
        }

        view.usun_wszystko2.setOnClickListener{
            deleteItems()
        }

*/

        return view
    }

    /*private fun updateItem(){
        val przedmiot = edytuj_przedmiot.text.toString()
        val godzinaOd = edytuj_godzinaOd.text.toString()
        val godzinaDo = edytuj_godzinaDo.text.toString()
        val minutaOd = edytuj_minutaOd.text.toString()
        val minutaDo = edytuj_minutaDo.text.toString()

        val spinner = view?.findViewById(R.id.dzienTygSpinner) as Spinner
        val dzien_tyg = spinner.selectedItem.toString()

        val new = Subject(args.currentSubject.user_id,przedmiot,dzien_tyg,"$godzinaOd:$minutaOd","$godzinaDo:$minutaDo")

        //update w view modelu
        viewModel.update(new)
        Toast.makeText(requireContext(),"Zakończono pomyślnie", Toast.LENGTH_LONG).show()
    }

    private fun deleteItem(){
        //viewModel.delete(args.currentStudent)
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Tak"){ _, _ ->
            viewModel.delete(args.currentSubject)
            Toast.makeText(requireContext(),"Usunięto", Toast.LENGTH_LONG).show()
        }
        builder.setNegativeButton("Nie"){ _, _ ->}
        builder.setMessage("Czy na pewno chcesz usunąć?")

        builder.create().show()



    }*/

    private fun deleteItems(){

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
