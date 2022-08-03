package com.example.countermvvm.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.countermvp.view.CounterView
import com.example.countermvvm.CounterViewModel
import com.example.countermvvm.databinding.FragmentHomeBinding


class HomeFragment : Fragment(),CounterView {

    private lateinit var binding: FragmentHomeBinding
     val viewModel:CounterViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveCounter().observe(viewLifecycleOwner,{
            binding.txtCount.text = it.toString()
        })
        viewModel.attachView(this)
        initClickers()

    }

    private fun initClickers() {
        with(binding){
           btnIncrease.setOnClickListener {
               viewModel.getIncreamentCount()
               viewModel.reaction()
           }
            btnDecrease.setOnClickListener {
                viewModel.getDecreamentCount()

            }
        }


    }

    override fun changeTextColor() {
        binding.txtCount.setTextColor(Color.GREEN)
    }

    override fun shortToast(msg: String) {
        Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()

    }
}





