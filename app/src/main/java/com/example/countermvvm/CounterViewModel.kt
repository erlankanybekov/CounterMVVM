package com.example.countermvvm

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countermvp.view.CounterView
import com.example.countermvvm.model.CounterModel
import com.example.countermvvm.repository.Repository

class CounterViewModel:ViewModel() {
    lateinit var view:CounterView

    private var click:Int = 0

    var repository = Repository()


    fun getLiveCounter(): MutableLiveData<Int> {
        return repository.getInitialCount()
    }

    fun getIncreamentCount(){
        click++
        repository.getInitialCount().value = click
    }
    fun getDecreamentCount(){
        click--
        repository.getInitialCount().value = click
    }

    fun reaction(){
        if (click == 15 ){
            view.changeTextColor()
        }
        if (click == 10){
            view.shortToast("Поздравляем")
        }
    }
    fun attachView(counterView: CounterView){
        view = counterView
    }




}