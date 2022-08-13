package com.example.countermvvm.fragments

import android.graphics.Color
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.countermvvm.CounterViewModel
import com.example.countermvvm.databinding.FragmentHomeBinding


class HomeFragment : Fragment(){

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
        viewModel.getInitialcount().observe(viewLifecycleOwner,{
            binding.txtCount.text = it.toString()
        })
        initClickers()

    }

    private fun initClickers() {
        with(binding){
           btnIncrease.setOnClickListener {
               viewModel.getIncreamentCount()
           }
            btnDecrease.setOnClickListener {
                    viewModel.getDecreamentCount()

                }

            }
        }


    }






