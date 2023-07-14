package com.rashmika.assignment_01.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.rashmika.assignment_01.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       var view =inflater.inflate(R.layout.fragment_main, container, false)

        var number1Field = view.findViewById<EditText>(R.id.edit_text1)
        var number2Field = view.findViewById<EditText>(R.id.editText)
        var message = view.findViewById<TextView>(R.id.result)
        var plusButton = view.findViewById<Button>(R.id.addition)
        var minusButton = view.findViewById<Button>(R.id.subtraction)
        var multiplyButton = view.findViewById<Button>(R.id.multiply)
        var divideButton = view.findViewById<Button>(R.id.divide)
        var clearbutton = view.findViewById<Button>(R.id.clearbtn)


        message.text = viewModel.result.value.toString()

        viewModel.result.observe(viewLifecycleOwner, Observer {
            message.text = it.toString()
        })

        plusButton.setOnClickListener {
            var number1 = number1Field?.text.toString().toDoubleOrNull()
            var number2 = number2Field?.text.toString().toDoubleOrNull()
            if (number1 != null) {
                if (number2 != null) {
                    viewModel.add(number1,number2)
                }
            }
        }

        minusButton.setOnClickListener {
            var number1 = number1Field?.text.toString().toDoubleOrNull()
            var number2 = number2Field?.text.toString().toDoubleOrNull()

            if (number1 != null) {
                if (number2 != null) {
                    viewModel.sub(number1,number2)
                }
            }
        }

        multiplyButton.setOnClickListener {
            var number1 = number1Field?.text.toString().toDoubleOrNull()
            var number2 = number2Field?.text.toString().toDoubleOrNull()

            if (number1 != null) {
                if (number2 != null) {
                    viewModel.multi(number1,number2)
                }
            }
        }

        divideButton.setOnClickListener {
            var number1 = number1Field?.text.toString().toDoubleOrNull()
            var number2 = number2Field?.text.toString().toDoubleOrNull()

            if (number1 != null) {
                if (number2 != null) {
                    viewModel.divide(number1,number2)
                }
            }
        }

        clearbutton.setOnClickListener {
            number1Field?.setText("")
            number2Field?.setText("")
            message.setText("")
        }





        return view
    }




}