package com.example.asystentnauczyciela.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import com.example.asystentnauczyciela.R
import com.example.asystentnauczyciela.viewmodel.SubjectsViewModel
import com.example.asystentnauczyciela.model.Subject
import kotlinx.android.synthetic.main.fragment_dodawanie_zajec.*
import android.widget.Spinner


class FragmentDodawanieZajec : Fragment() {
    private var dayOfWeek = "Poniedziałek" // default value
    private var t = "10" // default value
    private lateinit var viewModel: SubjectsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dodawanie_zajec, container, false)

        viewModel = ViewModelProvider(this).get(SubjectsViewModel::class.java)

        view.findViewById<Button>(R.id.dodaj_zajecia).setOnClickListener {
            insertData()
        }
        return view
    }

    private fun insertData() {
        val nazwa = wczytaj_przedmiot.text.toString()
        //val dzien_tyg = dzienTygSpinner.text.toString()
        val gOd = godzinaOd.text.toString()
        val mOd = minutaOd.text.toString()
        val gDo = godzinaDo.text.toString()
        val mDo = minutaDo.text.toString()

        val godzinaOd = "$gOd:$mOd"
        val godzinaDo = "$gDo:$mDo"

        val spinner = view?.findViewById(R.id.dzienTygSpinner) as Spinner
        val dzien_tyg = spinner.selectedItem.toString()

        val subject = Subject(0, nazwa, dzien_tyg, godzinaOd, godzinaDo)
        viewModel.insert(subject)
        Toast.makeText(requireContext(), "Dodano pomyślnie", Toast.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner: Spinner = view.findViewById(R.id.dzienTygSpinner)
        ArrayAdapter.createFromResource(
            this.requireActivity().applicationContext,
            R.array.days,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                dayOfWeek = parent.getItemAtPosition(pos).toString()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }


        }

    }
}








