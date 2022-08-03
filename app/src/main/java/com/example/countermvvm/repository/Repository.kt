package com.example.countermvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Repository {

   private var click:Int = 0
   private var countLiveData=MutableLiveData<Int>()

   fun getInitialCount():MutableLiveData<Int>{
      countLiveData.value = click
      return countLiveData
   }
}



