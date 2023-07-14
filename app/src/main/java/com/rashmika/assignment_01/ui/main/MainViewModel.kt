package com.rashmika.assignment_01.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var result = MutableLiveData<Double>()


    fun add(number1:Double,number2:Double){
        result.value = number1.plus(number2)
    }

    fun sub(number1: Double,number2: Double){
        result.value = number1.minus(number2)
    }

    fun multi(number1: Double,number2: Double){
        result.value = number1.times(number2)
    }

    fun divide(number1: Double,number2: Double){
        result.value = number1.div(number2)
    }
}