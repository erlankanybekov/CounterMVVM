package com.example.countermvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countermvvm.model.CounterModel

class CounterViewModel:ViewModel() {

    private var clickCount:Int =0
    private var countLiveData=MutableLiveData<Int>()

    fun getInitialcount():MutableLiveData<Int>{
        countLiveData.value=clickCount
        return countLiveData
    }

    fun getIncreamentCount(){
        clickCount+=1
        countLiveData.value=clickCount
    }

    fun getDecreamentCount(){
        clickCount-=1
        countLiveData.value=clickCount
    }




}